package vn.edu.likelion.bookstore.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDTO {
    String book_name;
    String author;
    int price;
    int quantity;
}