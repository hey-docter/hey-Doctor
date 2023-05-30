package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.vo.QuestionBookmarkVO;

public interface QuestionBookmarkService {
    public void setQuestionBookmarkVO(QuestionBookmarkVO questionBookmarkVO);

    public Boolean isBookmarkedByUser(Long UserId, Long questionId);
}
