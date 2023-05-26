package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.AdminMapper;
import com.heydoctor.app.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    public List<QuestionListDTO> findAll(Pagination pagination, Search search) {
        return adminMapper.selectLists(pagination, search);
    }

    public Optional<QuestionDTO> findById(Long questionId) {
        return Optional.ofNullable(adminMapper.select(questionId));
    }

    public void delete(Long questionId) {
        adminMapper.delete(questionId);
    }

    //    게시글 총 개수
    public int findCountOfPost(Search search){
        return adminMapper.selectCountOfPost(search);
    }

}
