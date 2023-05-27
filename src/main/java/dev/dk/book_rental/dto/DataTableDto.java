package dev.dk.book_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class DataTableDto {

    private int draw;

    private Map<String, String> columns;

    private List<TableOrder> order;
                              /*
                                column & dir(asc or desc)
                              */

    private int start;

    private int length;

    private String search;

    public String order_str() {

        String result_order = "";

        for(int i = 0; i < order.size(); i++) {

            result_order += (result_order.equals("") ? "" : ",")
                         + columns.get(order.get(i).getColumn())
                         + " "
                         + order.get(i).getDir();

        }

        if(result_order.equals("")) {

            result_order = "book_no desc";

        }

        return "ORDERED By " + result_order;
    }
}
