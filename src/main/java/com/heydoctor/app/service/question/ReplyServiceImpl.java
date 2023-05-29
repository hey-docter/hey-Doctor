package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.ReplyVO;
import jdk.jfr.StackTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service @Slf4j
@RequiredArgsConstructor
@Qualifier("reply") @Primary
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDAO replyDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReplyDTO write(ReplyVO replyVO) {
        replyDAO.insert(replyVO);
        Optional<ReplyDTO> checkReplyDTO = replyDAO.select(replyVO.getReplyId());
        log.info("============replyDTO: {}", checkReplyDTO.get());
        return checkReplyDTO.get();
    }

    @Override
    public Integer getCount(Long answerId) {
        return replyDAO.getCount(answerId);
    }

    @Override
    public ReplyDTO getReplyDTO(Long answerId) {
        return replyDAO.select(answerId).get();
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

    private ReplyDTO toDTO(ReplyVO replyVO) {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setReplyContent(replyVO.getReplyContent());
        replyDTO.setUserId(replyVO.getUserId());
        replyDTO.setReplyId(replyVO.getReplyId());
        return replyDTO;
    }
}
