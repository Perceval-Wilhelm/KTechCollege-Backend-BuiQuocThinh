package vn.edu.likelion.bookstore.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {
    String username;
    String password;
}
