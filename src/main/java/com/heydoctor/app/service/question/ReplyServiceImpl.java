package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("reply") @Primary
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDAO replyDAO;

    @Override
    public void insert(ReplyVO replyVO) {
        replyDAO.insert(replyVO);
    }

    @Override
    public List<ReplyDTO> getAllReplyDTO(Long... answerIds) {
        return replyDAO.selectAllReplyDTO(Arrays.asList(answerIds));
    }

    @Override
    public List<ReplyDTO> getAllReplyDTO(List<Long> answerIds) {
        return replyDAO.selectAllReplyDTO(answerIds);
    }

    @Override
    public List<ReplyVO> getAllAnswerReply() {
        return replyDAO.findAllAnswerReply();
    }
}
