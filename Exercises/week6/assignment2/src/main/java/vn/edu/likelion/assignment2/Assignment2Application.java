package vn.edu.likelion.assignment2;

import vn.edu.likelion.assignment2.model.*;

import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import vn.edu.likelion.assignment2.service.IAttribute;
import vn.edu.likelion.assignment2.service.IProduct;
import vn.edu.likelion.assignment2.service.IUser;
import vn.edu.likelion.assignment2.service.IWarehouse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment2Application {
	public static void main(String[] args) {
		IUser userDAO = new User();
		IWarehouse warehouseDAO = new Warehouse();
		IProduct productDAO = new Product();
		IAttribute attributeDAO = new Attribute();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Warehouse Management System");

		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		User authenticatedUser = userDAO.authenticateUser(username, password);
		if (authenticatedUser == null) {
			System.out.println("Invalid username or password");
			return;
		}

		System.out.println("Logged in as " + authenticatedUser.getUserName() + " with role ID " + authenticatedUser.getRoleID());

		while (true) {
			try {
				if (authenticatedUser.getRoleID() == 0) {
					System.out.println("\nAdmin Menu:");
					System.out.println("1. Add User");
					System.out.println("2. View All Users");
					System.out.println("3. Delete User");
					System.out.println("4. Add Warehouse");
					System.out.println("5. View All Warehouses");
					System.out.println("6. Delete Warehouse");
					System.out.println("7. Import Products from Excel");
					System.out.println("8. Assign User to Warehouse");
					System.out.println("9. Export User Report to Excel");
					System.out.println("10. Export Admin Report to Excel");
					System.out.println("11. Exit");

					System.out.print("Enter your choice: ");
					String choice = scanner.nextLine();

					switch (choice) {
						case "1":
							addUser(userDAO, scanner);
							break;
						case "2":
							viewAllUsers(userDAO);
							break;
						case "3":
							deleteUser(userDAO, scanner);
							break;
						case "4":
							addWarehouse(warehouseDAO, scanner);
							break;
						case "5":
							viewAllWarehouses(warehouseDAO);
							break;
						case "6":
							deleteWarehouse(warehouseDAO, productDAO, userDAO, scanner);
							break;
						case "7":
							importProductsFromExcel(productDAO, attributeDAO, warehouseDAO, scanner, authenticatedUser);
							break;
						case "8":
							assignUserToWarehouse(userDAO, warehouseDAO, scanner);
							break;
						case "9":
							exportUserReportToExcel(productDAO, authenticatedUser.getUserID(), scanner);
							break;
						case "10":
							exportAdminReportToExcel(productDAO, scanner);
							break;
						case "11":
							System.out.println("Exiting the program.");
							return;
						default:
							System.out.println("Invalid choice. Please try again.");
							break;
					}
				} else {
					System.out.println("\nUser Menu:");
					System.out.println("1. View Warehouse Products");
					System.out.println("2. Import Products from Excel");
					System.out.println("3. Export Products from Excel");
					System.out.println("4. Exit");

					System.out.print("Enter your choice: ");
					String choice = scanner.nextLine();

					switch (choice) {
						case "1":
							viewWarehouseProducts(productDAO, attributeDAO, authenticatedUser.getWarehouseID());
							break;
						case "2":
							importProductsFromExcel(productDAO, attributeDAO, warehouseDAO, scanner, authenticatedUser);
							break;
						case "3":
							exportUserReportToExcel(productDAO, authenticatedUser.getUserID(), scanner);
							break;
						case "4":
							System.out.println("Exiting the program.");
							return;
						default:
							System.out.println("Invalid choice. Please try again.");
							break;
					}
				}
			} catch (Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static void addUser(IUser userDAO, Scanner scanner) {
		try {
			User user = new User();
			System.out.print("Enter username: ");
			user.setUserName(scanner.nextLine());
			System.out.print("Enter password: ");
			user.setPassword(scanner.nextLine());
			System.out.print("Enter role ID: ");
			user.setRoleID(Integer.parseInt(scanner.nextLine()));

			System.out.print("Enter warehouse ID (or press Enter to skip): ");
			String warehouseIdInput = scanner.nextLine();
			if (warehouseIdInput.isEmpty()) {
				user.setWarehouseID(null);
			} else {
				user.setWarehouseID(Integer.parseInt(warehouseIdInput));
			}

			userDAO.createUser(user);
			System.out.println("User created successfully.");
		} catch (Exception e) {
			System.out.println("Failed to add user: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void viewAllUsers(IUser userDAO) {
		try {
			List<User> users = userDAO.getAllUsers();
			for (User user : users) {
				System.out.println(user.getUserName());
			}
		} catch (Exception e) {
			System.out.println("Failed to view users: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void deleteUser(IUser userDAO, Scanner scanner) {
		try {
			System.out.print("Enter user ID to delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			userDAO.deleteUser(id);
			System.out.println("User deleted successfully.");
		} catch (Exception e) {
			System.out.println("Failed to delete user: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void addWarehouse(IWarehouse warehouseDAO, Scanner scanner) {
		try {
			Warehouse warehouse = new Warehouse();
			System.out.print("Enter warehouse name: ");
			warehouse.setWarehouseName(scanner.nextLine());
			warehouseDAO.createWarehouse(warehouse);
			System.out.println("Warehouse created successfully.");
		} catch (Exception e) {
			System.out.println("Failed to add warehouse: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void viewAllWarehouses(IWarehouse warehouseDAO) {
		try {
			List<Warehouse> warehouses = warehouseDAO.getAllWarehouses();
			for (Warehouse warehouse : warehouses) {
				System.out.println(warehouse.getWarehouseName());
			}
		} catch (Exception e) {
			System.out.println("Failed to view warehouses: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void deleteWarehouse(IWarehouse warehouseDAO, IProduct productDAO, IUser userDAO, Scanner scanner) {
		try {
			System.out.print("Enter warehouse ID to delete: ");
			int warehouseId = Integer.parseInt(scanner.nextLine());

			List<Product> products = productDAO.getProductsByWarehouseId(warehouseId);
			if (!products.isEmpty()) {
				System.out.println("Warehouse has products. Please move them to another warehouse.");
				System.out.print("Enter the target warehouse ID to move products to: ");
				int targetWarehouseId = Integer.parseInt(scanner.nextLine());
				for (Product product : products) {
					product.setWarehouseID(targetWarehouseId);
					productDAO.updateProductWarehouse(product);
				}
				System.out.println("Products moved successfully.");
			}

			List<User> users = userDAO.getAllUsers();
			for (User user : users) {
				if (user.getWarehouseID() != null && user.getWarehouseID() == warehouseId) {
					System.out.println("User " + user.getUserName() + " is assigned to this warehouse. Please move them to another warehouse.");
					System.out.print("Enter the target warehouse ID to reassign the user: ");
					int targetWarehouseId = Integer.parseInt(scanner.nextLine());
					user.setWarehouseID(targetWarehouseId);
					userDAO.updateUser(user);
					System.out.println("User " + user.getUserName() + " moved successfully.");
				}
			}

			// Delete the warehouse after moving references
			warehouseDAO.deleteWarehouse(warehouseId);
			System.out.println("Warehouse deleted successfully.");
		} catch (Exception e) {
			System.out.println("Failed to delete warehouse: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void assignUserToWarehouse(IUser userDAO, IWarehouse warehouseDAO, Scanner scanner) {
		try {
			System.out.print("Enter user ID: ");
			int userId = Integer.parseInt(scanner.nextLine());

			User user = userDAO.getUserById(userId);
			if (user == null) {
				System.out.println("User not found.");
				return;
			}

			System.out.print("Enter warehouse ID to assign: ");
			int warehouseId = Integer.parseInt(scanner.nextLine());

			Warehouse warehouse = warehouseDAO.getWarehouseById(warehouseId);
			if (warehouse == null) {
				System.out.println("Warehouse not found.");
				return;
			}

			if (userDAO.getUserByWarehouseId(warehouseId) != null) {
				System.out.println("Warehouse already assigned to another user.");
				return;
			}

			user.setWarehouseID(warehouseId);
			userDAO.updateUser(user);
			System.out.println("User assigned to warehouse successfully.");
		} catch (Exception e) {
			System.out.println("Failed to assign user to warehouse: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void importProductsFromExcel(IProduct productDAO, IAttribute attributeDAO, IWarehouse warehouseDAO, Scanner scanner, User user) {
		int warehouseId = -1;

		if (user.getRoleID() == 0) {
			System.out.print("Enter the Warehouse ID to import products into: ");
			warehouseId = Integer.parseInt(scanner.nextLine());
		} else {
			warehouseId = user.getWarehouseID();
		}

		Warehouse warehouse = warehouseDAO.getWarehouseById(warehouseId);
		if (warehouse == null) {
			System.out.println("Warehouse not found. Please enter a valid Warehouse ID.");
			return;
		}

		System.out.print("Enter the path to the Excel file: ");
		String filePath = scanner.nextLine();

		try (FileInputStream fis = new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheetAt(0);
			int count = 0;
			for (Row row : sheet) {
				if (row.getRowNum() == 0) continue;

				Product product = new Product();
				product.setProductName(getCellValue(row.getCell(1)));
				product.setWarehouseID(warehouseId);
				productDAO.createProduct(product);

				int sizeAttribute = Integer.parseInt(getCellValue(row.getCell(2)));
				String typeAttribute = getCellValue(row.getCell(3));
				String colorAttribute = getCellValue(row.getCell(4));
				String brandAttribute = getCellValue(row.getCell(5));

				attributeDAO.getOrInsertAttribute(count, sizeAttribute, typeAttribute, colorAttribute, brandAttribute, product.getProductID());
			}

			workbook.close();
			System.out.println("Products imported successfully");
		} catch (Exception e) {
			System.out.println("Failed to import products from Excel: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String getCellValue(Cell cell) {
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue().toString();
				} else {
					return String.valueOf(cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case FORMULA:
				return cell.getCellFormula();
			default:
				return "";
		}
	}

	private static void viewWarehouseProducts(IProduct productDAO, IAttribute attributeDAO, int warehouseID) {
		try {
			System.out.println("Fetching products for warehouse ID: " + warehouseID);
			List<Product> products = productDAO.getProductsByWarehouseId(warehouseID);
			if (products.isEmpty()) {
				System.out.println("No products found in this warehouse.");
				return;
			}

			for (Product product : products) {
				System.out.println("Product Name: " + product.getProductName());
				List<ProductAttribute> attributes = productDAO.getProductAttributes(product.getProductID());
				for (ProductAttribute attribute : attributes) {
					System.out.println("  Size: " + attribute.getSizeAttribute());
					System.out.println("  Type: " + attribute.getTypeAttribute());
					System.out.println("  Color: " + attribute.getColorAttribute());
					System.out.println("  Brand: " + attribute.getBrandAttribute());
				}
			}
		} catch (Exception e) {
			System.out.println("Failed to view warehouse products: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void exportUserReportToExcel(IProduct productDAO, int userId, Scanner scanner) {
		System.out.print("Enter the path to save the Excel file: ");
		String filePath = scanner.nextLine();

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("User Report");
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("Warehouse ID");
			header.createCell(1).setCellValue("Warehouse Name");
			header.createCell(2).setCellValue("Total Products");

			List<WarehouseProductCount> warehouseProductCounts = productDAO.getWarehouseProductCountsForUser(userId);
			int rowNum = 1;
			for (WarehouseProductCount count : warehouseProductCounts) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(count.getWarehouseID());
				row.createCell(1).setCellValue(count.getWarehouseName());
				row.createCell(2).setCellValue(count.getProductCount());
			}

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
				System.out.println("User report exported successfully.");
			}
		} catch (IOException e) {
			System.out.println("Failed to export user report: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void exportAdminReportToExcel(IProduct productDAO, Scanner scanner) {
		System.out.print("Enter the path to save the Excel file: ");
		String filePath = scanner.nextLine();

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Admin Report");
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("Warehouse ID");
			header.createCell(1).setCellValue("Warehouse Name");
			header.createCell(2).setCellValue("Total Products");

			List<WarehouseProductCount> warehouseProductCounts = productDAO.getWarehouseProductCounts();
			int rowNum = 1;
			for (WarehouseProductCount count : warehouseProductCounts) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(count.getWarehouseID());
				row.createCell(1).setCellValue(count.getWarehouseName());
				row.createCell(2).setCellValue(count.getProductCount());
			}

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
				System.out.println("Admin report exported successfully.");
			}
		} catch (IOException e) {
			System.out.println("Failed to export admin report: " + e.getMessage());
			e.printStackTrace();
		}
	}
}