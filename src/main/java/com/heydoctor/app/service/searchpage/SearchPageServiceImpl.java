package com.heydoctor.app.service.searchpage;

import com.heydoctor.app.dao.SearchDAO;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchPageServiceImpl implements SearchPageService {
    private final SearchDAO searchDAO;

    @Override
    public List<QuestionDTO> getList(Search search) {
        return searchDAO.findAll(search);
    }

    @Override
    public List<QuestionDTO> getQuestion() {
        return searchDAO.findQuestion();
    }
}
