package vn.edu.likelion.assigment2jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.assigment2jpa.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}