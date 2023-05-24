package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.ReplyDAO;
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
    public List<ReplyVO> getAllReplyVO(Long... answerIds) {
        return replyDAO.selectAllReplyVO(Arrays.asList(answerIds));
    }

    @Override
    public List<ReplyVO> getAllReplyVO(List<Long> answerIds) {
        return replyDAO.selectAllReplyVO(answerIds);
    }

    @Override
    public List<ReplyVO> getAllAnswerReply() {
        return replyDAO.findAllAnswerReply();
    }
}
