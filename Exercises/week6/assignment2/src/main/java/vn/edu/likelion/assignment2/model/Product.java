package vn.edu.likelion.assignment2.model;

import vn.edu.likelion.assignment2.Connect;
import vn.edu.likelion.assignment2.service.IProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product implements IProduct {
    private int productID;
    private String productName;
    private int warehouseID;
    private Connect connect = new Connect();

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    @Override
    public void createProduct(Product product) {
        String sql = "INSERT INTO PRODUCT (ProductName) VALUES (?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"ProductID"})) {
            pstmt.setString(1, product.getProductName());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setProductID(generatedKeys.getInt(1));
                    addProductToWarehouse(product.getProductID(), product.getWarehouseID());
                }
            }
            System.out.println("Product created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductToWarehouse(int productId, int warehouseId) {
        String sql = "INSERT INTO WAREHOUSE_PRODUCT (WarehouseID, ProductID) VALUES (?, ?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, warehouseId);
            pstmt.setInt(2, productId);
            pstmt.executeUpdate();
            System.out.println("Product added to warehouse successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createProductAttribute(ProductAttribute productAttribute) {
        String sql = "INSERT INTO ATTRIBUTE (ProductID, SizeAttribute, TypeAttribute, ColorAttribute, BrandAttribute) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productAttribute.getProductID());
            pstmt.setInt(2, productAttribute.getSizeAttribute());
            pstmt.setString(3, productAttribute.getTypeAttribute());
            pstmt.setString(4, productAttribute.getColorAttribute());
            pstmt.setString(5, productAttribute.getBrandAttribute());
            pstmt.executeUpdate();
            System.out.println("Product attribute created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.ProductID, p.ProductName, wp.WarehouseID " +
                "FROM PRODUCT p " +
                "JOIN WAREHOUSE_PRODUCT wp ON p.ProductID = wp.ProductID";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setWarehouseID(rs.getInt("WarehouseID")); // Ensure WarehouseID is fetched correctly
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public List<ProductAttribute> getProductAttributes(int productId) {
        List<ProductAttribute> productAttributes = new ArrayList<>();
        String sql = "SELECT * FROM ATTRIBUTE WHERE ProductID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ProductAttribute productAttribute = new ProductAttribute();
                    productAttribute.setProductAttributeID(rs.getInt("AttributeID"));
                    productAttribute.setProductID(rs.getInt("ProductID"));
                    productAttribute.setSizeAttribute(rs.getInt("SizeAttribute"));
                    productAttribute.setTypeAttribute(rs.getString("TypeAttribute"));
                    productAttribute.setColorAttribute(rs.getString("ColorAttribute"));
                    productAttribute.setBrandAttribute(rs.getString("BrandAttribute"));
                    productAttributes.add(productAttribute);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productAttributes;
    }

    @Override
    public void updateProductWarehouse(Product product) {
        String sql = "UPDATE WAREHOUSE_PRODUCT SET WarehouseID = ? WHERE ProductID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, product.getWarehouseID());
            pstmt.setInt(2, product.getProductID());
            pstmt.executeUpdate();
            System.out.println("Product warehouse updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProductsByWarehouseId(int warehouseId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.ProductID, p.ProductName " +
                "FROM PRODUCT p " +
                "JOIN WAREHOUSE_PRODUCT wp ON p.ProductID = wp.ProductID " +
                "WHERE wp.WarehouseID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, warehouseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("ProductID"));
                    product.setProductName(rs.getString("ProductName"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<WarehouseProductCount> getWarehouseProductCountsForUser(int userId) {
        List<WarehouseProductCount> counts = new ArrayList<>();
        String sql = "SELECT w.WarehouseID, w.WarehouseName, COUNT(p.ProductID) AS ProductCount " +
                "FROM WAREHOUSE w " +
                "JOIN WAREHOUSE_PRODUCT wp ON w.WarehouseID = wp.WarehouseID " +
                "JOIN PRODUCT p ON wp.ProductID = p.ProductID " +
                "JOIN USERS u ON u.WarehouseID = w.WarehouseID " +
                "WHERE u.UserID = ? " +
                "GROUP BY w.WarehouseID, w.WarehouseName";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    WarehouseProductCount count = new WarehouseProductCount();
                    count.setWarehouseID(rs.getInt("WarehouseID"));
                    count.setWarehouseName(rs.getString("WarehouseName"));
                    count.setProductCount(rs.getInt("ProductCount"));
                    counts.add(count);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }

    public List<WarehouseProductCount> getWarehouseProductCounts() {
        List<WarehouseProductCount> counts = new ArrayList<>();
        String sql = "SELECT w.WarehouseID, w.WarehouseName, COUNT(p.ProductID) AS ProductCount " +
                "FROM WAREHOUSE w " +
                "JOIN WAREHOUSE_PRODUCT wp ON w.WarehouseID = wp.WarehouseID " +
                "JOIN PRODUCT p ON wp.ProductID = p.ProductID " +
                "GROUP BY w.WarehouseID, w.WarehouseName";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                WarehouseProductCount count = new WarehouseProductCount();
                count.setWarehouseID(rs.getInt("WarehouseID"));
                count.setWarehouseName(rs.getString("WarehouseName"));
                count.setProductCount(rs.getInt("ProductCount"));
                counts.add(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }
}