package vn.edu.likelion.assignment2jpa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base {

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    @NonNull
    private String product_name;

    @ManyToMany
    @JoinTable(name = "product_attribute",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private List<Attribute> attributes;

    public @NonNull String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(@NonNull String product_name) {
        this.product_name = product_name;
    }
}
