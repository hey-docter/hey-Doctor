package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {
    // 질문 목록 - 검색어 / 10개씩 무한로딩 DTO
    public List<QuestionVO> selectList(int page);

    // 질문 상세보기 - 질문에 따른 답변 - 답변에 따른 댓글
    public Optional<QuestionDTO> selectOne(Long questionId);

    //질문 지우기
    //
    public void delete(QuestionVO questionVO);
}
