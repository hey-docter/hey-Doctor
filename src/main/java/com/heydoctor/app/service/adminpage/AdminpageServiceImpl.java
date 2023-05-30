package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.dao.AdminDAO;
import com.heydoctor.app.dao.FileDAO;
import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminpageServiceImpl implements AdminpageService {
    private final AdminDAO adminDAO;
    private final ReplyDAO replyDAO;
    private final FileDAO fileDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<QuestionListDTO> getList(Pagination pagination, Search search) {
        //        게시글 전체 목록
        pagination.getPage();
        final List<QuestionListDTO> questions = adminDAO.findAll(pagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        questions.forEach(question -> question.setFiles(fileDAO.findAll(question.getQuestionId())));
        return questions;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<QuestionDTO> read(Long questionId) {
        return adminDAO.findById(questionId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> questionId) {
        questionId.forEach(question -> {
//            fileDAO.deleteAll(question);
            replyDAO.deleteAll(question);
            adminDAO.delete(question);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotal(Search search) {
        return adminDAO.findCountOfPost(search);
    }
}
