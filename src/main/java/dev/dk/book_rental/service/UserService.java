package dev.dk.book_rental.service;

import dev.dk.book_rental.dto.UserDto;
import dev.dk.book_rental.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean addUser(UserDto userDto) {

        int insert_count = userMapper.insertUser(userDto);

        return insert_count > -1 ? true : false;


    }

    public List<UserDto> getUserList() {

        return userMapper.selectUser();
    }
}
