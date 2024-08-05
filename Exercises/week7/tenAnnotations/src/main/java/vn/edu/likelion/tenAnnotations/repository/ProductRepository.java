package vn.edu.likelion.tenAnnotations.repository;

import org.springframework.stereotype.Repository;
import vn.edu.likelion.tenAnnotations.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Product product) {
        products.add(product);
    }

    public void delete(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
