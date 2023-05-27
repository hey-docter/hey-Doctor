package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QnaAnswerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaAnswerMapper {
    public void insert(QnaAnswerVO qnaAnswerVO);
    public List<QnaAnswerVO> selectByQnaId(Long qnaId);
}
