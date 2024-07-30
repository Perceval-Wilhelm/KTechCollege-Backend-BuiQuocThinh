package vn.edu.likelion.assignment2.model;

import vn.edu.likelion.assignment2.Connect;
import vn.edu.likelion.assignment2.service.IUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User implements IUser {
    private int userID;
    private String userName;
    private String password;
    private int roleID;
    private Integer warehouseID;
    private Connect connect = new Connect();

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Integer getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private String decodePassword(String encodedPassword) {
        return new String(Base64.getDecoder().decode(encodedPassword));
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO USERS (UserName, Password, RoleID, WarehouseID) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, encodePassword(user.getPassword()));
            pstmt.setInt(3, user.getRoleID());
            if (user.getWarehouseID() != null) {
                pstmt.setInt(4, user.getWarehouseID());
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM USERS WHERE UserID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassword(decodePassword(rs.getString("Password")));
                    user.setRoleID(rs.getInt("RoleID"));
                    user.setWarehouseID(rs.getInt("WarehouseID"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try (Connection conn = connect.openConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(decodePassword(rs.getString("Password")));
                user.setRoleID(rs.getInt("RoleID"));
                user.setWarehouseID(rs.getInt("WarehouseID"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM USERS WHERE UserID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE USERS SET UserName = ?, Password = ?, RoleID = ?, WarehouseID = ? WHERE UserID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, encodePassword(user.getPassword()));
            pstmt.setInt(3, user.getRoleID());
            if (user.getWarehouseID() != null) {
                pstmt.setInt(4, user.getWarehouseID());
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }
            pstmt.setInt(5, user.getUserID());
            pstmt.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User getUserByWarehouseId(int warehouseId) {
        String sql = "SELECT * FROM USERS WHERE WarehouseID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, warehouseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassword(decodePassword(rs.getString("Password")));
                    user.setRoleID(rs.getInt("RoleID"));
                    user.setWarehouseID(rs.getInt("WarehouseID"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User authenticateUser(String username, String password) {
        String sql = "SELECT * FROM USERS WHERE UserName = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = decodePassword(rs.getString("Password"));
                    if (storedPassword.equals(password)) {
                        User user = new User();
                        user.setUserID(rs.getInt("UserID"));
                        user.setUserName(rs.getString("UserName"));
                        user.setPassword(storedPassword);
                        user.setRoleID(rs.getInt("RoleID"));
                        user.setWarehouseID(rs.getInt("WarehouseID"));
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
