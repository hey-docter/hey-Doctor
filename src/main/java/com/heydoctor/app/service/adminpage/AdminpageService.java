package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface AdminpageService {
    public List<QuestionListDTO> getList(Pagination pagination, Search search);

    public Optional<QuestionDTO> read(Long questionId);

    public void delete(List<Long> questionId);


    //    게시글 전체 개수 조회
    public int getTotal(Search search);


}
