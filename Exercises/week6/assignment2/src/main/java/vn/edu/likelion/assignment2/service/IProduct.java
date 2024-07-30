package vn.edu.likelion.assignment2.service;

import vn.edu.likelion.assignment2.model.Product;
import vn.edu.likelion.assignment2.model.ProductAttribute;
import vn.edu.likelion.assignment2.model.WarehouseProductCount;

import java.util.List;

public interface IProduct {
    void createProduct(Product product);
//    int createProduct(Product product);
    void createProductAttribute(ProductAttribute productAttribute);
    List<Product> getAllProducts();
    List<ProductAttribute> getProductAttributes(int productId);
    void updateProductWarehouse(Product product);
    List<Product> getProductsByWarehouseId(int warehouseId);
    List<WarehouseProductCount> getWarehouseProductCounts();
    List<WarehouseProductCount> getWarehouseProductCountsForUser(int userId);
}
