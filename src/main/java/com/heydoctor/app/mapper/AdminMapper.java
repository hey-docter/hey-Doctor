package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    // 질문 목록 - 검색어 / 10개씩 무한로딩 DTO
    public List<QuestionListDTO> selectLists(@Param("pagination") Pagination pagination, @Param("search")Search search);

    // 질문 상세보기 - 질문에 따른 답변 - 답변에 따른 댓글
    public QuestionDTO select(Long questionId);

    //    // 질문 작성하기
//    // 사용시 id가 주입됨.
//    public void insert(QuestionVO questionVO);
    public void delete(Long questionId);

    //    게시글 총 개수
    public int selectCountOfPost(@Param("search") Search search);

}
