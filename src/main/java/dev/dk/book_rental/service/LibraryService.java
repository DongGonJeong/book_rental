package dev.dk.book_rental.service;

import dev.dk.book_rental.mapper.LibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    LibraryMapper libraryMapper;

    public String getViewText() {

        return libraryMapper.getText();

    }
}
