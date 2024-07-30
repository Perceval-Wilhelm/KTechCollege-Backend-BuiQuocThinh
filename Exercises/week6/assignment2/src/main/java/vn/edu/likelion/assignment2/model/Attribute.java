package vn.edu.likelion.assignment2.model;

import vn.edu.likelion.assignment2.service.IAttribute;
import vn.edu.likelion.assignment2.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Attribute implements IAttribute {
    private int attributeID;
    private int sizeAttribute;
    private String typeAttribute;
    private String colorAttribute;
    private String brandAttribute;
    private int productID;
    private Connect connect = new Connect();

    // Getters and Setters
    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public int getSizeAttribute() {
        return sizeAttribute;
    }

    public void setSizeAttribute(int sizeAttribute) {
        this.sizeAttribute = sizeAttribute;
    }

    public String getTypeAttribute() {
        return typeAttribute;
    }

    public void setTypeAttribute(String typeAttribute) {
        this.typeAttribute = typeAttribute;
    }

    public String getColorAttribute() {
        return colorAttribute;
    }

    public void setColorAttribute(String colorAttribute) {
        this.colorAttribute = colorAttribute;
    }

    public String getBrandAttribute() {
        return brandAttribute;
    }

    public void setBrandAttribute(String brandAttribute) {
        this.brandAttribute = brandAttribute;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public void createAttribute(Attribute attribute) {
        String sql = "INSERT INTO ATTRIBUTE (SizeAttribute, TypeAttribute, ColorAttribute, BrandAttribute, ProductID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, attribute.getSizeAttribute());
            pstmt.setString(2, attribute.getTypeAttribute());
            pstmt.setString(3, attribute.getColorAttribute());
            pstmt.setString(4, attribute.getBrandAttribute());
            pstmt.setInt(5, attribute.getProductID());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    attribute.setAttributeID(generatedKeys.getInt(1));
                }
            }
            System.out.println("Attribute created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Attribute> getAllAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        String sql = "SELECT * FROM ATTRIBUTE";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Attribute attribute = new Attribute();
                attribute.setAttributeID(rs.getInt("AttributeID"));
                attribute.setSizeAttribute(rs.getInt("SizeAttribute"));
                attribute.setTypeAttribute(rs.getString("TypeAttribute"));
                attribute.setColorAttribute(rs.getString("ColorAttribute"));
                attribute.setBrandAttribute(rs.getString("BrandAttribute"));
                attribute.setProductID(rs.getInt("ProductID"));
                attributes.add(attribute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attributes;
    }

    @Override
    public int getOrInsertAttribute(int count, int sizeAttribute, String typeAttribute, String colorAttribute, String brandAttribute, int productId) {
        int attributeId = -1;
        String selectSQL = "SELECT AttributeID FROM ATTRIBUTE WHERE SizeAttribute = ? AND TypeAttribute = ? AND ColorAttribute = ? AND BrandAttribute = ? AND ProductID = ?";
        String insertSQL = "INSERT INTO ATTRIBUTE (SizeAttribute, TypeAttribute, ColorAttribute, BrandAttribute, ProductID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect.openConnect();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Check if the attribute exists
            selectStmt.setInt(1, sizeAttribute);
            selectStmt.setString(2, typeAttribute);
            selectStmt.setString(3, colorAttribute);
            selectStmt.setString(4, brandAttribute);
            selectStmt.setInt(5, productId);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
//                    attributeId = rs.getInt("AttributeID");
                    attributeId = count;
                }
            }

            // If the attribute doesn't exist, insert it
            if (attributeId == -1) {
                insertStmt.setInt(1, sizeAttribute);
                insertStmt.setString(2, typeAttribute);
                insertStmt.setString(3, colorAttribute);
                insertStmt.setString(4, brandAttribute);
                insertStmt.setInt(5, productId);
                insertStmt.executeUpdate();

                try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
//                        attributeId = generatedKeys.getInt(1);
                        attributeId = count;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: " + e.getMessage());
            e.printStackTrace();
        }
        return attributeId;
    }
}