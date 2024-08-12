package vn.edu.likelion.bookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {
    int book_id;
    String book_name;
    String author;
    int price;
    int quantity;
    int sold;
}
