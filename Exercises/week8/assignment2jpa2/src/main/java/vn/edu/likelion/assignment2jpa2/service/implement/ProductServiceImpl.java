package vn.edu.likelion.assignment2jpa2.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assignment2jpa2.entity.Product;
import vn.edu.likelion.assignment2jpa2.repository.ProductRepo;
import vn.edu.likelion.assignment2jpa2.service.ProductService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Iterator<Product> findAll() {
        return productRepo.findAll().iterator();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }
}
