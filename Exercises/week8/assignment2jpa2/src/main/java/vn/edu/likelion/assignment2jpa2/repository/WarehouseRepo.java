package vn.edu.likelion.assignment2jpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.assignment2jpa2.entity.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {
}
