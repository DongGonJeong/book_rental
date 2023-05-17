package dev.dk.book_rental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private int book_no;
    private String name;
    private String writer;
    private String publication_dt;
    private int price;
}
