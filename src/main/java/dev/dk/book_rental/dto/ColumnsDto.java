package dev.dk.book_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnsDto {

    private String data;
    private String name;
    private boolean searchable;
    private boolean orderable;
    private SearchDto search;
}
