package dev.dk.book_rental.controller;

import com.zaxxer.hikari.util.ConcurrentBag;
import dev.dk.book_rental.dto.BookDto;
import dev.dk.book_rental.dto.DataTableDto;
import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/rest_book",
        method = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class RestBookController {

//    @Autowired
//    LibraryService libraryService;

    @Autowired
    BookService bookService;

//    @PostMapping("list")
//    public String book_list(@RequestBody DataTableDto dataTableDto) {
//
//        List<BookDto> book_list = bookService.getBookList();
//
//        return "/book/list";
//    }
//    @PostMapping("list")
//    public String book_list(Model model) {
//
//        List<BookDto> book_list = bookService.getBookList();
//
//        model.addAttribute("book_list", book_list);
//
//        return "redirect:/book/list.html";
//
//    }
    @PostMapping("list")
    public Map<String, Object> book_list(@ModelAttribute DataTableDto dataTableDto) {

        System.out.println(dataTableDto.toString());

        dataTableDto.setDraw(dataTableDto.getDraw() + 1);

        Map<String, Object> result_map =  new HashMap<>();

        List<BookDto> book_list = bookService.getBookList(dataTableDto.order_str());

        result_map.put("draw", dataTableDto.getDraw());


        return result_map;

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
    public Map<String, Object> add_book(@RequestBody BookDto bookDto) {

        System.out.println("bookDto ==>> " + bookDto);

        Map<String, Object> map = new HashMap<>();

        boolean add_check = bookService.addBook(bookDto);

        System.out.println("rest_add_check ==>> " + add_check);

        map.put("Status", add_check);

//        return "redirect:/rest_book/list";
//        return new ResponseEntity<String>(add_check, HttpStatus.OK);
        return map;
    }
}
