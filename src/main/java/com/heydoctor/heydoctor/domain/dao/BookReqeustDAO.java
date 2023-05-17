package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.BookRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookReqeustDAO {
    private final BookRequestMapper bookRequestMapper;
}
