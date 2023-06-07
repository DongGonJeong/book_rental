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

    private String button;

    private int borrow_user_no = -1;

    public BookDto(String name, String writer, String publication_dt, int price) {

        this.name = name;
        this.writer = writer;
        this.publication_dt = publication_dt;
        this.price = price;
    }

    public void createButton() {

        if(book_no > 0) {

            button = "<input id=\"edit_"+book_no+"\" type=\"button\" value=\"수정\" class=\"btn btn-modify\" style=\"background-color: lightskyblue;\" onclick=\"update_book("+book_no+", 'U')\">"
                    +
                    "<input type=\"button\" value=\"삭제\"\n" +
                    "class=\"btn btn-delete\" style=\"background-color: lightpink; margin-left: 1em !important\" onclick=\"update_book("+book_no+", 'D')\">"
                    +
                    "<input type=\"button\" value=\"대여"+(borrow_user_no != -1?"불가":"")+"\" "+(borrow_user_no != -1?"disabled":"")+" class=\"btn btn-info\" style=\"background-color: lightgreen; " +
                    "margin-left:1em !important;\" onclick=\"book_lend(" + book_no + ")\">";

        }


    }
}
