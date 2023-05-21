package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    public void insert(AnswerVO answerVO);
    public List<AnswerVO> selectByQuestionId(Long questionId);
}
