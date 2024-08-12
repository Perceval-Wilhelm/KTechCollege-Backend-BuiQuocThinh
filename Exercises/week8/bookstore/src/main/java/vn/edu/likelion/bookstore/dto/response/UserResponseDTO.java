package vn.edu.likelion.bookstore.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDTO {
    int user_id;
    String username;
    LocalDate createTime;
    LocalDate updateTime;
}
