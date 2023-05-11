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

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/user",
        method = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class UserController {

//    @Autowired
//    LibraryService libraryService;

    @Autowired
    UserService userService;

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




    }
}
