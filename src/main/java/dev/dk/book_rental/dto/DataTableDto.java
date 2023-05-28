package dev.dk.book_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTableDto {

    private String draw;

    private List<ColumnsDto> columns;

    private List<TableOrderDto> order;
                              /*
                                column & dir(asc or desc)
                                --------------------------

                                @ class 명을,,
                                  TableOderDto로 고쳐야,,
                                  error 발생안함!!
                              */

    private int start;

    private int length;

    private String search;

    public String order_str() {

        String result_order = "";

        try {

            for(int i = 0; i < order.size(); i++) {

                result_order += (result_order.equals("") ? "" : ",")

                        + columns.get(Integer.parseInt(order.get(i).getColumn()))
                        + " "
                        + order.get(i).getDir();

            }

        } catch(NullPointerException e) {

            System.out.println("order 리스트 넘어오지 않음");

        }

        if(result_order.equals("")) {

            result_order = "book_no desc";

        }

        return "ORDER By " + result_order;
    }
}



