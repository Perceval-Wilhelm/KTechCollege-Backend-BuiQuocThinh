package vn.edu.likelion.assignment2.service;

import vn.edu.likelion.assignment2.model.Warehouse;

import java.util.List;

public interface IWarehouse {
    void createWarehouse(Warehouse warehouse);
    List<Warehouse> getAllWarehouses();
    void deleteWarehouse(int id);
    Warehouse getWarehouseById(int id);
}
