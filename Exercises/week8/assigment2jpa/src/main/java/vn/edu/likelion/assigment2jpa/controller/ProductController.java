package vn.edu.likelion.assigment2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.assigment2jpa.entity.ProductEntity;
import vn.edu.likelion.assigment2jpa.service.ProductService;

import java.util.Iterator;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity createProduct(@RequestParam String name) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        return productService.create(product);
    }

    @GetMapping
    public Iterator<ProductEntity> getProducts() {
        return productService.findAll();
    }
}
