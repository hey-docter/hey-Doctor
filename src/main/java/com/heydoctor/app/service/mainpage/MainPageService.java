package com.heydoctor.app.service.mainpage;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.UserVO;

import java.util.List;
import java.util.Optional;

public interface MainPageService {
    //public List<MainDTO> selectReadCount();

    public List<MainDTO> selectQuestionReadCount();

    public List<MainDTO> selectAnswerAll();

    public List<MainDTO> selectAdopCount();

    public List<MainDTO> selectVisitCount();

    public Optional<UserVO> selectUserId(Long userId);
}
