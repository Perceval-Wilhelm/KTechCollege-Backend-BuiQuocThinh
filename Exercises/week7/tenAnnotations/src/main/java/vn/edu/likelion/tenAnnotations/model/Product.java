package vn.edu.likelion.tenAnnotations.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Product {
    private Long id;
    private String name;
    private String description;

    public Product() {}

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters

    @PostConstruct
    public void init() {
        System.out.println("Product initialized: " + this.name);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Product destroyed: " + this.name);
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
