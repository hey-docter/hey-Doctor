package com.heydoctor.app.service.mypage;


import com.heydoctor.app.dao.MypageDAO;
import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("mypage") @Primary

public class MyPageServiceImpl implements MyPageService {
    private final MypageDAO mypageDAO;

    //게시글 목록
    @Override
    public List<QuestionVO>  getQuestionList(Long id) {
        return mypageDAO.findQuestionAll(id);
    }

    @Override
    public List<AnswerDTO> getAnswerList(Long id) {
        return mypageDAO.findAnswerAll(id);
    }

    @Override
    public List<ReplyDTO> getReplyList(Long id) {
        return mypageDAO.findReplyAll(id);
    }
//    public List<QuestionVO> getQuestionList(Pagination pagination) {
//        final List<QuestionVO> questions = mypageDAO.findQuestionAll(pagination);
////        Questions.forEach(question -> question.setFiles(fileDAO.findAll(question.getId())));
//        return questions;
//    }
    //답변 목록
//    public List<AnswerDTO> getAnswerList(Pagination pagination) {
//        final List<AnswerDTO> answers = mypageDAO.findAnswerAll(pagination);
////        Questions.forEach(question -> question.setFiles(fileDAO.findAll(question.getId())));
//        return answers;
//    }
//    //댓글 목록
//    public List<ReplyDTO> getReplyList(Pagination pagination) {
//        final List<ReplyDTO> questions = mypageDAO.findReplyAll(pagination);
////        Questions.forEach(question -> question.setFiles(fileDAO.findAll(question.getId())));
//        return questions;
    }

