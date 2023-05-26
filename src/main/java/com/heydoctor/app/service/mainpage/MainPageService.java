package com.heydoctor.app.service.mainpage;

import com.heydoctor.app.domain.dto.MainDTO;

import java.util.List;

public interface MainPageService {
    public List<MainDTO> selectReadCount();

    public List<MainDTO> selectAdopCount();

    public List<MainDTO> selectVisitCount();
}
