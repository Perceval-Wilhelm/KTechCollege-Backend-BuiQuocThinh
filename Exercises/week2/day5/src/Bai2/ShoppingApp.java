package Bai2;

import java.util.Random;

public class ShoppingApp {
    public static void main(String[] args) {
        Random rand = new Random();

        Product prod1 = new Product(rand.nextInt(0, 1000), "Product 1", rand.nextDouble(10, 100));
        Product prod2 = new Product(rand.nextInt(0, 1000), "Product 2", rand.nextDouble(10, 100));
        Product prod3 = new Product(rand.nextInt(0, 1000), "Product 3", rand.nextDouble(10, 100));

        Cart cart = new Cart();
        cart.addToCart(prod1);
        cart.addToCart(prod2);
        cart.addToCart(prod3);

        for (Product prod : cart.getProducts()) {
            System.out.println("Product ID: " + prod.getProductId() + ", Product Name: " + prod.getProductName() + ", Price: " + prod.getPrice() + ", Store name: " + Product.storeName);
        }

        double total = cart.totalPrice();
        System.out.println("Total price: " + total);
    }
}
