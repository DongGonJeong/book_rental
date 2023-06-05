package dev.dk.book_rental.controller;

import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapperScan("dev.dk.book_rental.mapper")
@RequestMapping(value = "/rest_user",
        method = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class RestUserController {

    @Autowired
    UserService userService;

    @PostMapping("sign_in_process")
    public Map<String, Object> sign_in_process(HttpServletRequest request) {

        Map<String, Object> result_map = new HashMap<>();

        boolean status = false;

        String msg = "로그인 실패";

        int user_no = Integer.parseInt(request.getParameter("login_id"));

        String pw = request.getParameter("login_pw");

//        UserDto userDto = new UserDto();
        UserDto userDto = userService.getUserInfo(user_no);

        if(userDto == null) {

            msg = "해당하는 회원정보가없습니다!";

        } else {

            try {

                if(pw.equals(userDto.getPw())) {

                    status = true;
                }
            } catch(Exception e) {

                System.err.println("error 발생");

                e.printStackTrace();
            }
        }

        HttpSession session = request.getSession();

        session.setAttribute("userInfo", userDto);

        result_map.put("status", status);
        result_map.put("msg", msg);

        return result_map;

    }


    @GetMapping("get_list")
    @PostMapping
    @ResponseBody
    public Map<String, Object> user_list(Model model) {

        List<UserDto> user_list = userService.getUserList();

        model.addAttribute("user_list", user_list);

        for(int i = 0; i < user_list.size(); i++) {

            UserDto userDto = user_list.get(i);

            userDto.createButton();

        }

        Map<String,Object> result_map = new HashMap<>();

        result_map.put("draw", 1);
        result_map.put("recordsTotal", user_list.size());
        result_map.put("recordsFiltered", user_list.size());
        result_map.put("data", user_list);

        return result_map;


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
    public Map<String, Object> add_user(@RequestBody UserDto userDto) {

        System.out.println("userDto ==>>" + userDto);

        Map<String, Object> map = new HashMap<>();

        boolean add_check = userService.addUser(userDto);

        System.out.println("add_check ==>> " + add_check);

        map.put("Status", add_check);

        return map;

    }
}
