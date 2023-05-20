package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    // 질문 목록 - 검색어 / 10개씩 무한로딩 DTO
    public List<QuestionVO> selectList(Integer page);

    // 질문 상세보기 - 질문에 따른 답변 - 답변에 따른 댓글
    public QuestionDTO selectOne(Long questionId);

    // 질문 작성하기
    // 사용시 id가 주입됨.
    public void insert(QuestionVO questionVO);

}
