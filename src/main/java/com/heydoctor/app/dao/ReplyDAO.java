package com.heydoctor.app.dao;

import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public void insert(ReplyVO replyVO) {
        replyMapper.insert(replyVO);
    }

    public List<ReplyVO> selectAllReplyVO(List<Long> answerIds) {
        return replyMapper.selectAllReplyVO(answerIds);
    }
}
