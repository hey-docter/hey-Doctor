package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    public void insert(ReplyVO replyVO);
    public List<ReplyDTO> getAllReplyDTO(Long... answerIds);
    public List<ReplyDTO> getAllReplyDTO(List<Long> answerIds);

    public List<ReplyVO> getAllAnswerReply();
}
