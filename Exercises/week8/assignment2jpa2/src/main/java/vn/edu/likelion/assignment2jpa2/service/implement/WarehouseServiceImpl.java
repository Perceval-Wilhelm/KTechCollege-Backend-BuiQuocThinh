package vn.edu.likelion.assignment2jpa2.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assignment2jpa2.entity.Warehouse;
import vn.edu.likelion.assignment2jpa2.repository.WarehouseRepo;
import vn.edu.likelion.assignment2jpa2.service.WarehouseService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepo warehouseRepo;

    @Override
    public Warehouse create(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }

    @Override
    public Warehouse update(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }

    @Override
    public void delete(Warehouse warehouse) {
        warehouseRepo.delete(warehouse);
    }

    @Override
    public Iterator<Warehouse> findAll() {
        return warehouseRepo.findAll().iterator();
    }

    @Override
    public Optional<Warehouse> findById(int id) {
        return warehouseRepo.findById(id);
    }
}
