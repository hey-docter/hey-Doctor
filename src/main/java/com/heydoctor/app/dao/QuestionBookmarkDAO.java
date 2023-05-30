package com.heydoctor.app.dao;

import com.heydoctor.app.domain.vo.QuestionBookmarkVO;
import com.heydoctor.app.mapper.QuestionBookmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionBookmarkDAO {
    private final QuestionBookmarkMapper questionBookmarkMapper;

    public void insert(QuestionBookmarkVO bookmarkVO) {
        questionBookmarkMapper.insert(bookmarkVO);
    }

    public Integer getCount(Long bookmarkId) {
        return questionBookmarkMapper.count(bookmarkId);
    }

    public Boolean isBookmarkedByUser(Long userId, Long questionId) {
        return questionBookmarkMapper.check(userId, questionId);
    }

}
