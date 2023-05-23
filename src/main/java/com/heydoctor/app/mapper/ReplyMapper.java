package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insert(ReplyVO replyVO);
    public List<ReplyVO> selectAllReplyVO(List<Long> answerIds);
    //    댓글 삭제
    public void delete(Long replyId);

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long answerId);
}
