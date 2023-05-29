package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    public void insert(AnswerVO answerVO);
    public List<AnswerDTO> selectByQuestionId(Long questionId);
    public AnswerDTO select(Long answerId);
//    답변 왕 조회
    public List<AnswerVO> selectByAdoptCount();
}
