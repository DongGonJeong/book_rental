package dev.dk.book_rental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

//    private String user_no;
    private int user_no;

    private String pw;

    private String name;
    private int age;
    private String hp;
    private String address;

    private String status;
    private String Status_reason;

    private int max_count;
    private int on_rental_count;

    private String button;

    public void createButton() {

        if(user_no > 0) {

            button = "<input id=\"edit_"+user_no+"\" type=\"button\" value=\"수정\" class=\"btn btn-modify\" style=\"background-color: lightskyblue;\" onclick=\"update_user("+user_no+", 'U')\">"
                    +
                    "<input type=\"button\" value=\"삭제\"\n" +
                    "                                   class=\"btn btn-delete\" style=\"background-color: lightpink; margin-left: 1em !important\" onclick=\"update_user("+user_no+", 'D')\">";
        }


    }


}
