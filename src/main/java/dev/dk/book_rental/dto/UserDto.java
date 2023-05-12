package dev.dk.book_rental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String user_no;
    private String name;
    private int age;
    private String hp;
    private String address;

    private String status;
    private String Status_reason;

    private int max_count;
    private int on_rental_count;

}
