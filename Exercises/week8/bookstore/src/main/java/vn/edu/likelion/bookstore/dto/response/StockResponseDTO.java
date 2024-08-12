package vn.edu.likelion.bookstore.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockResponseDTO {
    int book_id;
    LocalDate createTime;
    String book_name;
    String author;
    int price;
    int pre_quantity;
    int quantity_stock;
    int after_quantity;
    String type;
    int sold;
}
