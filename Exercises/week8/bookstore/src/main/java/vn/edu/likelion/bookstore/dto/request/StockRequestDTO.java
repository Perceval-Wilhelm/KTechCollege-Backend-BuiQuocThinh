package vn.edu.likelion.bookstore.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockRequestDTO {
    int book_id;
    int quantity_stock;
}
