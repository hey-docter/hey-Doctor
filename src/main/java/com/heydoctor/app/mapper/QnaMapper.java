package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QnaVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QnaMapper {
    // 질문 목록 - 검색어 / 10개씩 무한로딩 DTO
    public List<QnaDTO> selectList(@Param("pagination") Pagination pagination, @Param("search") Search search);

    // 질문 상세보기 - 질문에 따른 답변 - 답변에 따른 댓글
    public Optional<QnaDTO> selectOne(Long qnaId);

    //게시글 삭제
    public void delete(Long qnaId);

    //게시글 삭제
    public void insert(QnaVO qnaVO);

    //    게시글 총 개수
    public int selectCountOfPost(@Param("search") Search search);
}