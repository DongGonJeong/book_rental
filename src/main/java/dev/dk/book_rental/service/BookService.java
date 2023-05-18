package dev.dk.book_rental.service;

import dev.dk.book_rental.dto.BookDto;
import dev.dk.book_rental.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public boolean addBook(BookDto bookDto) {

        int insert_count = bookMapper.insertBook(bookDto);

        return insert_count > -1 ? true : false;
    }

    public List<BookDto> getBookList() {

        return bookMapper.selectBook();
    }

    public BookDto getBookInfo(int book_no) {

        BookDto bookDto = bookMapper.selectOneBook(book_no);

        return bookDto;
    }

    public boolean updateBook(BookDto bookDto) {

        int update_count = bookMapper.updateBook(bookDto);

        return update_count > -1 ? true : false;
    }

    public boolean removeBook(int book_no) {

        int delete_count = bookMapper.deleteBook(book_no);

        return delete_count > -1 ? true : false;


    }
}