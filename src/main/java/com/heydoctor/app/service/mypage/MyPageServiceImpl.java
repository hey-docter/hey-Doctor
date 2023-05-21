package com.heydoctor.app.service.mypage;


import com.heydoctor.app.dao.QuestionDAO;
import com.heydoctor.app.domain.vo.QuestionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("mypage") @Primary
public class MyPageServiceImpl implements MyPageService {
    private final QuestionDAO questionDAO;
//    list 가져오기
    @Override
    public List<QuestionVO> getList(Integer page) {
        return questionDAO.findAll(page);
    }
}
