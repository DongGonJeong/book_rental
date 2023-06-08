package dev.dk.book_rental.controller;

import com.zaxxer.hikari.util.ConcurrentBag;
import dev.dk.book_rental.dto.BookDto;
import dev.dk.book_rental.dto.DataTableDto;
import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("update_process")
    public String update_process(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");

        String writer = request.getParameter("writer");

        String publication_dt = request.getParameter("publication_dt");

        int price = Integer.parseInt(request.getParameter("price"));

        int book_no = Integer.parseInt(request.getParameter("book_no"));

        BookDto bookDto = new BookDto();

        bookDto.setName(name);
        bookDto.setWriter(writer);
        bookDto.setPublication_dt(publication_dt);
        bookDto.setPrice(price);


        bookDto.setBook_no(book_no);

        boolean update_check = bookService.updateBook(bookDto);


        return "redirect:/book/list.html";

    }



    //    @GetMapping("list")
    @PostMapping("list")
    public Map<String, Object> book_list(

            @ModelAttribute DataTableDto dataTableDto,
            HttpServletRequest request) {

        HttpSession session = request.getSession();

        UserDto userDto = (UserDto) session.getAttribute("userInfo");

        System.out.println(userDto);

        System.out.println(dataTableDto.toString());

        dataTableDto.setDraw(dataTableDto.getDraw() + 1);

        Map<String, Object> result_map =  new HashMap<>();

        List<BookDto> book_list = bookService.getBookList(dataTableDto.order_str());

        List<BookDto> bookDTOFilterList = new ArrayList<>();

        for(int i = 0; i < book_list.size(); i++) {

            BookDto bookDto = book_list.get(i);

            if(
                    bookDto.getName().equals(dataTableDto.getSearch())
                            || bookDto.getWriter().equals(dataTableDto.getSearch())
                            || bookDto.getPublication_dt().equals(dataTableDto.getSearch())
                            || dataTableDto.getSearch() == null
            ) {

                bookDto.createButton(userDto);

                bookDTOFilterList.add(bookDto);

            }

        }

        System.out.println(bookDTOFilterList.get(0));

        result_map.put("draw", dataTableDto.getDraw());

        result_map.put("recordsTotal",book_list.size());
        result_map.put("recordsFiltered",bookDTOFilterList.size());
        result_map.put("data",bookDTOFilterList);

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
