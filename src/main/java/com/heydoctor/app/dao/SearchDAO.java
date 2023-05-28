package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchDAO {
    private final SearchMapper searchMapper;

    public List<QuestionDTO> findAll(Search search){
        return searchMapper.selectAll(search);
    }

    public List<QuestionDTO> findQuestion() {return searchMapper.selectOne();}
}
