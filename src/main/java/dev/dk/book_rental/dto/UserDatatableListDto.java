package dev.dk.book_rental.dto;

import lombok.Data;

import java.util.List;

@Data
class Columns {

    private String db;
    private int dt;
}

@Data
class ColumnsList {

    private List<Columns> columnsList;

}

@Data
class Order {

    private String column;
    private String dir;
}

@Data
class OrderList {

    private List<Order> orderList;
}

@Data
class DataList {

    List<UserDto> userList;
}


@Data
public class UserDatatableListDto {

    private int draw;

    private ColumnsList columnsList;

    private OrderList orderList;

    private int start;

    private int length;

    private String search;
//    -------------------------------------------

    private int recordsTotal;

    private int recordsFiltered;

    private DataList data;


}


