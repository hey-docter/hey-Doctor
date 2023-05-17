package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.BookRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookReqeustDAO {
    private final BookRequestMapper bookRequestMapper;
}
