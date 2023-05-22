package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    public void insert(ReplyVO replyVO);
    public List<ReplyVO> getAllReplyVO(Long... answerIds);
    public List<ReplyVO> getAllReplyVO(List<Long> answerIds);

}
