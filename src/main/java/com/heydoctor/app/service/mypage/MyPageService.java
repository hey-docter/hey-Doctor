package com.heydoctor.app.service.mypage;


import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.*;

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

    // 질문 좋아요 갯수
    public QuestionLikeCountVO getQuestionLike(Long id);
    // 답변 좋아요 갯수
    public AnswerLikeCountVO getAnswerLike(Long id);
    // 댓글 좋아요 갯수
    public ReplyLikeCountVO getReplyLike(Long id);
}

