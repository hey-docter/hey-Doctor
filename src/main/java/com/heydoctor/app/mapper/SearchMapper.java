package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.BookReqeustVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    // 게시글 목록 찾기
    public List<QuestionDTO> selectAll(Search search);
    public void insert(QuestionDTO questionDTO);
    public List<QuestionDTO> selectOne();

    // 게시글 총 개수
    public int selectCount(Search search);

    public List<BookReqeustVO> selectAllBook(Search search);
}
