package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MypageMapper {
    //    질문 게시글 목록
    public List<QuestionVO> selectQuestionAll(Long id);

    // 질문 답변 목록
    public List<AnswerDTO> selectAnswerAll(Long id);

    //    질문 댓글 목록
    public List<ReplyDTO> selectReplyAll(Long id);


}
