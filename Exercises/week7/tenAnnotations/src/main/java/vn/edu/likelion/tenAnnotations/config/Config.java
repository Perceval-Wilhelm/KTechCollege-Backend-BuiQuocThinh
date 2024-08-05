package vn.edu.likelion.tenAnnotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import vn.edu.likelion.tenAnnotations.model.Product;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public Product productPrototype() {
        return new Product("Prototype Product", "Prototype Description");
    }

    @Bean
    public Product productSingleton() {
        return new Product("Singleton Product", "Singleton Description");
    }
}
