package com.heydoctor.app.service.mypage;


import com.heydoctor.app.dao.MypageDAO;
import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.UserVO;
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
    //답변 목록
    @Override
    public List<AnswerDTO> getAnswerList(Long id) {
        return mypageDAO.findAnswerAll(id);
    }
    //댓글 목록
    @Override
    public List<ReplyDTO> getReplyList(Long id) {
        return mypageDAO.findReplyAll(id);
    }

    // 유저 정보 불러오기
    @Override
    public UserVO getUser(Long id){
        return mypageDAO.findUser(id);
    }

    }

