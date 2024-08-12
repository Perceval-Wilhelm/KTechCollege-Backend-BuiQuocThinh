package vn.edu.likelion.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends Base {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    @NonNull
    String book_name;

    @Column(nullable = false)
    @NonNull
    String author;

    @Column(nullable = false)
    int price;

    @Column(nullable = false)
    int quantity;

    @Column()
    int sold;
}
