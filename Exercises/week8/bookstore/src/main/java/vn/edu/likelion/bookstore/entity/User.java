package vn.edu.likelion.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Base {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;
}
