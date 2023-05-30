package com.heydoctor.app.service.searchpage;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.BookReqeustVO;

import java.util.List;

public interface SearchPageService {
//    검색기능
    public List<QuestionDTO> getList(Search search);
    public List<QuestionDTO> getQuestion();
    public List<BookReqeustVO> getBookList(Search search);

    // 게시글 전체 개수 조회
    public int getTotal(Search search);
}
