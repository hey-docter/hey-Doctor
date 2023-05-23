package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.dao.AdminDAO;
import com.heydoctor.app.dao.FileDAO;
import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminpageServiceImpl implements AdminpageService {
    private final AdminDAO adminDAO;
    private final ReplyDAO replyDAO;

    @Override
    public List<QuestionListDTO> getList(Integer page) {
        return adminDAO.findAll(page);
    }

    @Override
    public Optional<QuestionDTO> read(Long questionId) {
        return adminDAO.findById(questionId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long questionId) {
        adminDAO.delete(questionId);
        replyDAO.deleteAll(questionId);
    }
}
