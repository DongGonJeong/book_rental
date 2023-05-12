package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.LibraryService;
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
@RequestMapping(value = "/user",
        method = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class UserController {

//    @Autowired
//    LibraryService libraryService;

    @Autowired
    UserService userService;

    @PostMapping("list")
    public String user_list(Model model) {

        List<UserDto> user_list = userService.getUserList();

        model.addAttribute("user_list", user_list);

        return "/user/list";

    }

    @PostMapping("user_add")
    public String user_add_form() {

        return "/user/add_form";
    }

    @PostMapping("")
    public String user_index() {

        return "/user/index";
    }

    @PostMapping("add")
    public String add_user(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model)
    {
        String name = request.getParameter("name");

        int age = Integer.parseInt(request.getParameter("age"));

        String hp = request.getParameter("hp");

        String address = request.getParameter("address");

        UserDto userDto = new UserDto();

        userDto.setName(name);
        userDto.setAge(age);
        userDto.setHp(hp);
        userDto.setAddress(address);

        boolean add_check = userService.addUser(userDto);

        System.out.println("add_check ==>> " + add_check);

        return "redirect:/user/list";

    }
}