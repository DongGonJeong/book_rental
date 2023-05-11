package dev.dk.book_rental.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibraryMapper {

    String getText();
}
