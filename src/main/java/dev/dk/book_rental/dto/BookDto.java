package dev.dk.book_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int book_no;
    private String name;
    private String writer;
    private String publication_dt;
    private int price;

    public BookDto(String name, String writer, String publication_dt, int price) {

        this.name = name;
        this.writer = writer;
        this.publication_dt = publication_dt;
        this.price = price;
    }
}
