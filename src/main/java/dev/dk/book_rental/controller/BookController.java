package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.BookDto;
import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.BookService;
import dev.dk.book_rental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/book",
        method = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class BookController {

//    @Autowired
//    LibraryService libraryService;

    @Autowired
    BookService bookService;

    @PostMapping("lend")
    public String book_lend(HttpServletRequest request) {

        int book_no = Integer.parseInt(request.getParameter("book_no"));

        int user_no = ((UserDto)request.getSession().getAttribute("userInfo")).getUser_no();

        bookService.setLendBook(book_no, user_no);

        return "redirect:/book/list.html";

    }

    @PostMapping("detail")
    public String detail_book(HttpServletRequest request, Model model) {

        int book_no = Integer.parseInt(request.getParameter("book_no"));

        BookDto bookDto = bookService.getBookInfo(book_no);

        model.addAttribute("bookInfo", bookDto);

        return "/book/detail";

    }

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

    @PostMapping("update")
    public  String update_delete(HttpServletRequest request, Model model) {

        int book_no = Integer.parseInt(request.getParameter("book_no"));

        String type = request.getParameter("type");

        if(type.equals("U")) {

            BookDto bookDto = bookService.getBookInfo(book_no);

            model.addAttribute("bookInfo", bookDto);

            return "/book/update_form";

        } else {

            bookService.removeBook(book_no);

        }

//        return "redirect:/book/list";
        return "redirect:/book/list.html";

    }

    @PostMapping("list")
    public String book_list(Model model) {

//        List<BookDto> book_list = bookService.getBookList();

//        model.addAttribute("book_list", book_list);

        return "redirect:/book/list.html";
//        return "/book/list";

    }

    @PostMapping("book_add")
    public String book_add_form() {

//        return "/book/add_form";
        return "redirect:/book/add_form.html";

    }

    @PostMapping("")
    public String book_index() {

//        return "/book/index";
        return "redirect:/book/index.html";
    }

    @PostMapping("add")
    public String add_book(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model)
    {
        String name = request.getParameter("name");

        String writer = request.getParameter("writer");

        String publication_dt = request.getParameter("publication_dt");

        int price = Integer.parseInt(request.getParameter("price"));

//        BookDto bookDto = new BookDto();
        BookDto bookDto = new BookDto(name, writer, publication_dt, price);

//        bookDto.setName(name);
//        bookDto.setWriter(writer);
//        bookDto.setPublication_dt(publication_dt);
//        bookDto.setPrice(price);

        boolean add_check = bookService.addBook(bookDto);

        System.out.println("add_check ==>> " + add_check);

        return "redirect:/book/list";

    }
}
