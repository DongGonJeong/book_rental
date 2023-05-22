package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.BookDto;
import dev.dk.book_rental.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/rest_book",
        method = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class RestBookController {

//    @Autowired
//    LibraryService libraryService;

    @Autowired
    BookService bookService;

    @PostMapping("list")
    public String book_list(Model model) {

        List<BookDto> book_list = bookService.getBookList();

        model.addAttribute("book_list", book_list);

        return "/book/list";

    }

    @PostMapping("book_add")
    public String book_add_form() {

//        return "/book/add_form";
        return "redirect:/book/add_form.html";

    }

    @PostMapping("")
    public String book_index() {

        return "/book/index";
    }

    @PostMapping("add")
    public String add_book(@RequestBody BookDto bookDto) {

        System.out.println("bookDto ==>> " + bookDto);

        boolean add_check = bookService.addBook(bookDto);

        System.out.println("add_check ==>> " + add_check);

        return "add_check";

    }
}
