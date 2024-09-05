package vn.edu.likelion.assigment2jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tbl_attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttributeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @NonNull
    private String name;
}