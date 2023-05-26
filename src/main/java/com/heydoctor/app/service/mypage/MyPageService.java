package com.heydoctor.app.service.mypage;


import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.UserVO;

import java.util.List;

public interface MyPageService {
    // 질문 게시글 목록
    public List<QuestionVO> getQuestionList(Long id);

    // 질문 답변 목록
    public List<AnswerDTO> getAnswerList(Long id);

    // 질문 댓글 목록
    public List<ReplyDTO> getReplyList(Long id);

    // 유저 정보 불러오기
    public UserVO getUser(Long id);


}

