package com.heydoctor.app.service.searchpage;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;

import java.util.List;

public interface SearchPageService {
//    검색기능
    public List<QuestionDTO> getList(Search search);
    public List<QuestionDTO> getQuestion();
}
