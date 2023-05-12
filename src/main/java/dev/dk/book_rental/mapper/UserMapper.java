package dev.dk.book_rental.mapper;

import dev.dk.book_rental.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(@Param(value = "user") UserDto userDto);

    List<UserDto> selectUser();
}
