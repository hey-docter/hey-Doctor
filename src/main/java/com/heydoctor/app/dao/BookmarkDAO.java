package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.BookmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookmarkDAO {
    private final BookmarkMapper bookmarkMapper;

    public Integer getCount(Long bookmarkId) {
        return bookmarkMapper.count(bookmarkId);
    }
}
