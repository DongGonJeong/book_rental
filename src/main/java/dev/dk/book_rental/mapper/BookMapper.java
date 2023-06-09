package dev.dk.book_rental.mapper;

import dev.dk.book_rental.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    int insertBook(@Param(value = "book") BookDto bookDto);

    List<BookDto> selectBook(String order);

    BookDto selectOneBook(@Param(value = "book_no") int book_no);

    int updateBook(@Param(value = "book") BookDto bookDto);

    int deleteBook(@Param(value = "book_no") int book_no);

    void updateLendBook(@Param(value = "book_no") int book_no, @Param(value = "user_no") int user_no);

    void updateRentalCount(@Param(value = "user_no") int user_no);

    void updateReturnBook(@Param(value = "book_no") int book_no);

}
