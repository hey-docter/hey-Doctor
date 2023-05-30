package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.QuestionBookmarkDAO;
import com.heydoctor.app.domain.vo.QuestionBookmarkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("questionBookmark") @Primary
public class QuestionBookmarkServiceImpl implements QuestionBookmarkService {
    private final QuestionBookmarkDAO questionBookmarkDAO;

    @Override
    public void setQuestionBookmarkVO(QuestionBookmarkVO questionBookmarkVO) {
        questionBookmarkDAO.insert(questionBookmarkVO);
    }

    @Override
    public Boolean isBookmarkedByUser(Long userId, Long questionId) {
        return questionBookmarkDAO.isBookmarkedByUser(userId,questionId);
    }

}
