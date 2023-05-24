package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/rest_user",
        method = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class RestUserController {

    @Autowired
    UserService userService;


    @PostMapping("list")
    public String user_list(Model model) {

        List<UserDto> user_list = userService.getUserList();

        model.addAttribute("user_list", user_list);

        return "redirect:/user/list.html";

    }

    @PostMapping("user_add")
    public String user_add_form() {

        return "redirect:/user/add_form.html";
    }

    @PostMapping("")
    public String user_index() {

//        return "/user/index";
        return "redirect:/user/index.html";
    }

    @PostMapping("add")
    public String add_user(
            @RequestBody UserDto userDto)
    {

        System.out.println(userDto);

        boolean add_check = userService.addUser(userDto);

        System.out.println("add_check ==>> " + add_check);

        return "redirect:/rest_user/list";

    }
}
