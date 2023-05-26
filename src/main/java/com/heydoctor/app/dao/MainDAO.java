package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.mapper.MainMapper;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MainDAO {
    private final MainMapper mainMapper;
//    QUESITON 조회순 정렬
    public List<MainDTO> findReadCount() {
        return mainMapper.selectReadCount();
    }

    public List<MainDTO> findAdopCount() {
        return mainMapper.selectAdoptCount();
    }

    public List<MainDTO> findVisitCount(){
        return mainMapper.selectVisitCount();
    }
}
