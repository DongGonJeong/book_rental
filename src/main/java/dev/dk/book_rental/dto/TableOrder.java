package dev.dk.book_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableOrder {

    private String column;

    private String dir;
      /*
        asc or desc
      */
}
