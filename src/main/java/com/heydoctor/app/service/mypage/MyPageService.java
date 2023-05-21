package com.heydoctor.app.service.mypage;


import com.heydoctor.app.domain.vo.QuestionVO;

import java.util.List;

public interface MyPageService {
    public List<QuestionVO> getList(Integer page);
}
