package vn.edu.likelion.assigment2jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assigment2jpa.entity.WarehouseEntity;
import vn.edu.likelion.assigment2jpa.repository.WarehouseRepository;
import vn.edu.likelion.assigment2jpa.service.WarehouseService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository wareHouseRepository;

    @Override
    public WarehouseEntity create(WarehouseEntity wareHouseEntity) {
        return wareHouseRepository.save(wareHouseEntity);
    }

    @Override
    public WarehouseEntity update(WarehouseEntity wareHouseEntity) {
        return wareHouseRepository.save(wareHouseEntity);
    }

    @Override
    public void delete(WarehouseEntity wareHouseEntity) {
        wareHouseRepository.delete(wareHouseEntity);
    }

    @Override
    public Iterator<WarehouseEntity> findAll() {
        return wareHouseRepository.findAll().iterator();
    }

    @Override
    public Optional<WarehouseEntity> findById(Long id) {
        return Optional.empty();
    }
}
