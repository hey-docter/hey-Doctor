package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    // 게시글 목록 찾기
    public List<QuestionDTO> selectAll(Search search);
    public void insert(QuestionDTO questionDTO);

    public List<QuestionDTO> selectOne();
}
