package vn.edu.likelion.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = true, updatable = false)
    LocalDate createTime = LocalDate.now();

    @Column(nullable = true, insertable = false)
    LocalDate updateTime;

    @Column
    int isDeleted;
}
