package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.ReplyDTO;
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

    public List<ReplyDTO> selectAllReplyDTO(List<Long> answerIds) {
        return replyMapper.selectAllReplyDTO(answerIds);
    }

    //    댓글 삭제
    public void delete(Long replyId){
        replyMapper.delete(replyId);
    }

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long answerId){
        replyMapper.deleteAll(answerId);
    }

    // 의사 댓글만 불러오는 것들
    public List<ReplyVO> findAllAnswerReply() {
        return replyMapper.selectAllAnswerReply();
    }
}
