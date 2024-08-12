package vn.edu.likelion.assignment2jpa2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Attribute")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attribute extends Base {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @NonNull
    private String attribute_name;

    public @NonNull String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(@NonNull String attribute_name) {
        this.attribute_name = attribute_name;
    }
}
