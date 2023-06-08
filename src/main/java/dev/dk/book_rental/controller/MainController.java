package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.LibraryService;
import jakarta.servlet.http.HttpServletRequest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@MapperScan("dev.dk.book_rental.mapper")
@Controller
@RequestMapping(
        value = "/",
        method = {RequestMethod.GET, RequestMethod.POST})
public class MainController {

    @Autowired
    LibraryService libraryService;


//    @PostMapping("")
//    public String hello(Model model) {
//
////        System.out.println("GET 방식 request ==>> OK");
//
//        String view_text = libraryService.getViewText();
//
//        model.addAttribute("view_text", view_text);
//
////        return "/index0";
//        return "redirect:/index.html";
//
//    }

    @PostMapping("user_add")
    public String user_add_form() {

        return "redirect:/user/add_form.html";
    }

    @PostMapping("")
    public String user_index(HttpServletRequest request) {

        UserDto userDto = (UserDto) request.getSession().getAttribute("userInfo");

        String url = "redirect:/index.html";
//        String url = "redirect:/book/index.html";

        if(userDto == null) {

            url = "redirect:sign_in/index.html";

        }

        System.err.println(url);

        return url;

    }
}
