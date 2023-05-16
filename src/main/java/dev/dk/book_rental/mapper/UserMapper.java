package dev.dk.book_rental.mapper;

import dev.dk.book_rental.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.annotation.Repeatable;
import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(@Param(value = "user") UserDto userDto);

    List<UserDto> selectUser();

    UserDto selectOneUser(@Param(value = "user_no") int user_no);

    int updateUser(@Param(value = "user") UserDto userDto);

    int deleteUser(@Param(value = "user_no") int user_no);
}
