package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.QuestionBookmarkVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionBookmarkMapper {
    public void insert(QuestionBookmarkVO bookmarkVO);
    public Integer count(Long bookmarkId);
    public Boolean check(Long userId, Long questionId);
}
