//package vn.edu.likelion.BaiTap;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.sql.*;
//import java.util.Base64;
//import java.util.Scanner;
//
//public class BaiTapApplication {
//	public static void main(String[] args) {
//		Connect conn = null;
//		PreparedStatement stat = null;
//		ResultSet resultSet = null;
//		Scanner scanner = new Scanner(System.in);
//
//		try {
//			System.out.println("Welcome to the Attendance System");
//
//			System.out.print("Enter username: ");
//			String username = scanner.nextLine();
//
//			System.out.print("Enter password: ");
//			String password = scanner.nextLine();
//
//			conn = new Connect();
//			String role = authenticateUser(conn, username, password);
//			if (role == null) {
//				System.out.println("Invalid username or password");
//				return;
//			}
//
//			System.out.println("Logged in as " + username + " with role " + role);
//
//			while (true) {
//				System.out.println("\nMenu:");
//				System.out.println("1. Mark Attendance");
//				System.out.println("2. View Present Students");
//				System.out.println("3. View Absent Students");
//				System.out.println("4. View All Students");
//				System.out.println("5. Load Students from File");
//				System.out.println("6. Exit");
//
//				System.out.print("Enter your choice: ");
//				String choice = scanner.nextLine();
//
//				switch (choice) {
//					case "1":
//						if (!checkPermissions(conn, username, "Mark Attendance")) {
//							System.out.println("You do not have permission to mark attendance.");
//						} else {
//							System.out.print("Enter student ID: ");
//							int studentId = Integer.parseInt(scanner.nextLine());
//							System.out.print("Is the student present? (yes/no): ");
//							boolean presence = scanner.nextLine().equalsIgnoreCase("yes");
//							markAttendance(conn, studentId, presence);
//							System.out.println("Attendance marked.");
//						}
//						break;
//					case "2":
//						if (!checkPermissions(conn, username, "View Present Students")) {
//							System.out.println("You do not have permission to view attendance.");
//						} else {
//							viewAttendance(conn, true);
//						}
//						break;
//					case "3":
//						if (!checkPermissions(conn, username, "View Absent Students")) {
//							System.out.println("You do not have permission to view attendance.");
//						} else {
//							viewAttendance(conn, false);
//						}
//						break;
//					case "4":
//						if (!checkPermissions(conn, username, "View All Students")) {
//							System.out.println("You do not have permission to view all attendance.");
//						} else {
//							viewAllAttendance(conn);
//						}
//						break;
//					case "5":
//						System.out.print("Enter file path: ");
//						String filePath = scanner.nextLine();
//						loadStudentsFromFile(conn, filePath);
//						System.out.println("Students loaded from file.");
//						break;
//					case "6":
//						System.out.println("Exiting the program.");
//						return;
//					default:
//						System.out.println("Invalid choice. Please try again.");
//						break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) conn.closeConnect();
//				if (stat != null) stat.close();
//				if (resultSet != null) resultSet.close();
//			} catch (SQLException s) {
//				s.printStackTrace();
//			}
//		}
//	}
//
//	private static String encodePassword(String password) {
//		return Base64.getEncoder().encodeToString(password.getBytes());
//	}
//
//	private static String authenticateUser(Connect conn, String username, String password) throws SQLException {
//		String sql = "SELECT RoleName FROM USERS JOIN ROLE ON USERS.RoleID = ROLE.RoleID WHERE Username=? AND Password=?";
//		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			stmt.setString(1, username);
//			stmt.setString(2, encodePassword(password));
//			ResultSet rs = stmt.executeQuery();
//			if (rs.next()) {
//				return rs.getString("RoleName");
//			} else {
//				return null;
//			}
//		} finally {
//			conn.closeConnect();
//		}
//	}
//
//	private static boolean checkPermissions(Connect conn, String username, String action) throws SQLException {
//		String sql = "SELECT PermissionName FROM USERS " +
//				"JOIN ROLE ON USERS.RoleID = ROLE.RoleID " +
//				"JOIN ROLE_PERMISSION ON ROLE.RoleID = ROLE_PERMISSION.RoleID " +
//				"JOIN PERMISSION ON ROLE_PERMISSION.PermissionID = PERMISSION.PermissionID " +
//				"WHERE Username=? AND PermissionName=?";
//		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			stmt.setString(1, username);
//			stmt.setString(2, action);
//			ResultSet rs = stmt.executeQuery();
//			return rs.next();
//		} finally {
//			conn.closeConnect();
//		}
//	}
//
//	private static void markAttendance(Connect conn, int studentId, boolean presence) throws SQLException {
//		String sql = "INSERT INTO ATTENDANCE (StudentID, Dates, Presence) VALUES (?, SYSDATE, ?)";
//		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			stmt.setInt(1, studentId);
//			stmt.setBoolean(2, presence);
//			stmt.executeUpdate();
//		} finally {
//			conn.closeConnect();
//		}
//	}
//
//	private static void viewAttendance(Connect conn, boolean present) throws SQLException {
//		String sql = "SELECT STUDENT.StudentID, STUDENT.StudentName FROM STUDENT " +
//				"JOIN ATTENDANCE ON STUDENT.StudentID = ATTENDANCE.StudentID " +
//				"WHERE ATTENDANCE.Presence = ?";
//		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			stmt.setBoolean(1, present);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt("StudentID") + " - " + rs.getString("StudentName"));
//			}
//		} finally {
//			conn.closeConnect();
//		}
//	}
//
//	private static void viewAllAttendance(Connect conn) throws SQLException {
//		String sql = "SELECT STUDENT.StudentID, STUDENT.StudentName, ATTENDANCE.Presence FROM STUDENT " +
//				"LEFT JOIN ATTENDANCE ON STUDENT.StudentID = ATTENDANCE.StudentID ";
////				"AND ATTENDANCE.Dates = TRUNC(SYSDATE)";
//		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String presence = rs.getBoolean("Presence") ? "Present" : "Absent";
//				System.out.println(rs.getInt("StudentID") + " - " + rs.getString("StudentName") + " - " + presence);
//			}
//		} finally {
//			conn.closeConnect();
//		}
//	}
//
//	private static void loadStudentsFromFile(Connect conn, String filePath) throws SQLException {
//		String sql = "INSERT INTO STUDENT (StudentID, StudentName, Status) VALUES (?, ?, ?)";
//		try (BufferedReader br = new BufferedReader(new FileReader(filePath));
//			 PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
//			String line;
//			while ((line = br.readLine()) != null) {
//				String[] parts = line.split("\t");
//				stmt.setInt(1, Integer.parseInt(parts[0]));
//				stmt.setString(2, parts[1]);
//				stmt.setBoolean(3, Integer.parseInt(parts[2]) == 1);
//				stmt.addBatch();
//			}
//			stmt.executeBatch();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			conn.closeConnect();
//		}
//	}
//}

package vn.edu.likelion.BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Base64;
import java.util.Scanner;

public class BaiTapApplication {
	public static void main(String[] args) {
		Connect conn = null;
		PreparedStatement stat = null;
		ResultSet resultSet = null;
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Welcome to the Attendance System");

			System.out.print("Enter username: ");
			String username = scanner.nextLine();

			System.out.print("Enter password: ");
			String password = scanner.nextLine();

			conn = new Connect();
			String role = authenticateUser(conn, username, password);
			if (role == null) {
				System.out.println("Invalid username or password");
				return;
			}

			System.out.println("Logged in as " + username + " with role " + role);

			while (true) {
				System.out.println("\nMenu:");
				System.out.println("1. Mark Attendance");
				System.out.println("2. View Present Students");
				System.out.println("3. View Absent Students");
				System.out.println("4. View All Students");
				System.out.println("5. Load Students from File");
				System.out.println("6. Exit");

				System.out.print("Enter your choice: ");
				String choice = scanner.nextLine();

				switch (choice) {
					case "1":
						if (!checkPermissions(conn, username, "Mark Attendance")) {
							System.out.println("You do not have permission to mark attendance.");
						} else {
							markAllAttendance(conn, scanner);
						}
						break;
					case "2":
						if (!checkPermissions(conn, username, "View Present Students")) {
							System.out.println("You do not have permission to view attendance.");
						} else {
							viewAttendance(conn, true);
						}
						break;
					case "3":
						if (!checkPermissions(conn, username, "View Absent Students")) {
							System.out.println("You do not have permission to view attendance.");
						} else {
							viewAttendance(conn, false);
						}
						break;
					case "4":
						if (!checkPermissions(conn, username, "View All Students")) {
							System.out.println("You do not have permission to view all attendance.");
						} else {
							viewAllStudents(conn);
						}
						break;
					case "5":
						System.out.print("Enter file path: ");
						String filePath = scanner.nextLine();
						loadStudentsFromFile(conn, filePath);
						System.out.println("Students loaded from file.");
						break;
					case "6":
						System.out.println("Exiting the program.");
						return;
					default:
						System.out.println("Invalid choice. Please try again.");
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.closeConnect();
				if (stat != null) stat.close();
				if (resultSet != null) resultSet.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
	}

	private static String encodePassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	private static String authenticateUser(Connect conn, String username, String password) throws SQLException {
		String sql = "SELECT RoleName FROM USERS JOIN ROLE ON USERS.RoleID = ROLE.RoleID WHERE Username=? AND Password=?";
		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, encodePassword(password));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("RoleName");
			} else {
				return null;
			}
		} finally {
			conn.closeConnect();
		}
	}

	private static boolean checkPermissions(Connect conn, String username, String action) throws SQLException {
		String sql = "SELECT PermissionName FROM USERS " +
				"JOIN ROLE ON USERS.RoleID = ROLE.RoleID " +
				"JOIN ROLE_PERMISSION ON ROLE.RoleID = ROLE_PERMISSION.RoleID " +
				"JOIN PERMISSION ON ROLE_PERMISSION.PermissionID = PERMISSION.PermissionID " +
				"WHERE Username=? AND PermissionName=?";
		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, action);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} finally {
			conn.closeConnect();
		}
	}

	private static void markAllAttendance(Connect conn, Scanner scanner) throws SQLException {
		String sqlSelectStudents = "SELECT StudentID, StudentName FROM STUDENT";
		String sqlInsertAttendance = "INSERT INTO ATTENDANCE (StudentID, AttendanceDate, Presence) VALUES (?, TRUNC(SYSDATE), ?)";
		String sqlUpdateStatus = "UPDATE STUDENT SET Status = ? WHERE StudentID = ?";

		try (PreparedStatement stmtSelect = conn.openConnect().prepareStatement(sqlSelectStudents);
			 PreparedStatement stmtInsertAttendance = conn.openConnect().prepareStatement(sqlInsertAttendance);
			 PreparedStatement stmtUpdateStatus = conn.openConnect().prepareStatement(sqlUpdateStatus)) {

			ResultSet rs = stmtSelect.executeQuery();
			while (rs.next()) {
				int studentId = rs.getInt("StudentID");
				String studentName = rs.getString("StudentName");

				System.out.print("Is " + studentName + " (ID: " + studentId + ") present? (yes/no): ");
				boolean presence = scanner.nextLine().equalsIgnoreCase("yes");

				// Insert into ATTENDANCE table
				stmtInsertAttendance.setInt(1, studentId);
				stmtInsertAttendance.setInt(2, presence ? 1 : 0);
				stmtInsertAttendance.executeUpdate();

				// Update status in STUDENT table
				stmtUpdateStatus.setInt(1, presence ? 1 : 0);
				stmtUpdateStatus.setInt(2, studentId);
				stmtUpdateStatus.executeUpdate();
			}
		} finally {
			conn.closeConnect();
		}
	}

	private static void viewAttendance(Connect conn, boolean present) throws SQLException {
		String sql = "SELECT STUDENT.StudentID, STUDENT.StudentName FROM STUDENT " +
				"JOIN ATTENDANCE ON STUDENT.StudentID = ATTENDANCE.StudentID " +
				"WHERE TRUNC(ATTENDANCE.AttendanceDate) = TRUNC(SYSDATE) AND ATTENDANCE.Presence = ?";
		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
			stmt.setInt(1, present ? 1 : 0);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("StudentID") + " - " + rs.getString("StudentName"));
			}
		} finally {
			conn.closeConnect();
		}
	}

	private static void viewAllStudents(Connect conn) throws SQLException {
		String sql = "SELECT STUDENT.StudentID, STUDENT.StudentName, STUDENT.Status FROM STUDENT";
		try (PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String status = rs.getInt("Status") == 1 ? "Present" : (rs.getInt("Status") == 0 ? "Absent" : "No Attendance Recorded");
				System.out.println(rs.getInt("StudentID") + " - " + rs.getString("StudentName") + " - " + status);
			}
		} finally {
			conn.closeConnect();
		}
	}

	private static void loadStudentsFromFile(Connect conn, String filePath) throws SQLException {
		String sql = "INSERT INTO STUDENT (StudentID, StudentName, Status) VALUES (?, ?, NULL)";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath));
			 PreparedStatement stmt = conn.openConnect().prepareStatement(sql)) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\t");
				if (parts.length >= 3) {
					stmt.setInt(1, Integer.parseInt(parts[0]));
					stmt.setString(2, parts[1]);
					stmt.addBatch();
				}
			}
			stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.closeConnect();
		}
	}
}




