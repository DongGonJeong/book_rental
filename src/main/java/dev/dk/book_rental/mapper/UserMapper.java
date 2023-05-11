package dev.dk.book_rental.mapper;

import dev.dk.book_rental.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int insertUser(@Param(value = "user") UserDto userDto);
}
