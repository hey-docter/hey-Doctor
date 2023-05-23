package com.heydoctor.app.service.mypage;


import com.heydoctor.app.dao.MypageDAO;
import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("mypage") @Primary

public class MyPageServiceImpl implements MyPageService {
    private final QuestionVO questionVO;
    private final AnswerDTO answerDTO;
    private final ReplyDTO replyDTO;

//    @Override
//    public List<QuestionVO> getQuestionList(Integer page) {
//        return MypageDAO.findQuestionAll(page);
//    }
//
//    @Override
//    public List<AnswerDTO> getAnswerList() {
//        return MypageDAO.findAnswerAll();
//    }

    @Override
    public List<ReplyDTO> getReplyList() {
        return MypageDAO.;
    }




}