package vn.edu.likelion.assignment2.model;

import vn.edu.likelion.assignment2.Connect;
import vn.edu.likelion.assignment2.service.IWarehouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements IWarehouse {
    private int warehouseID;
    private String warehouseName;
    private Connect connect = new Connect();

    // Getters and Setters
    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public void createWarehouse(Warehouse warehouse) {
        String sql = "INSERT INTO WAREHOUSE (WarehouseName) VALUES (?)";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, warehouse.getWarehouseName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = new ArrayList<>();
        String sql = "SELECT * FROM WAREHOUSE";
        try (Connection conn = connect.openConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setWarehouseID(rs.getInt("WarehouseID"));
                warehouse.setWarehouseName(rs.getString("WarehouseName"));
                warehouses.add(warehouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return warehouses;
    }

    @Override
    public void deleteWarehouse(int id) {
        String sql = "DELETE FROM WAREHOUSE WHERE WarehouseID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Warehouse deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Warehouse getWarehouseById(int id) {
        String sql = "SELECT * FROM WAREHOUSE WHERE WarehouseID = ?";
        try (Connection conn = connect.openConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWarehouseID(rs.getInt("WarehouseID"));
                    warehouse.setWarehouseName(rs.getString("WarehouseName"));
                    return warehouse;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
