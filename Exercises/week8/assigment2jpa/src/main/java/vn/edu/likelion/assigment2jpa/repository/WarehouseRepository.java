package vn.edu.likelion.assigment2jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.assigment2jpa.entity.AttributeEntity;
import vn.edu.likelion.assigment2jpa.entity.WarehouseEntity;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {
}
