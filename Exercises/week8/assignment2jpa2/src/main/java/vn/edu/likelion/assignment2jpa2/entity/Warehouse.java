package vn.edu.likelion.assignment2jpa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "Warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse extends Base {

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    @NonNull
    private String warehouse_name;

    @Column
    private String address;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private User user_id;

    @ManyToMany
    @JoinTable(name = "warehouse_product",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public @NonNull String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(@NonNull String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }
}
