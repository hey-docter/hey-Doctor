package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.MainMapper;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MainDAO {
    private final MainMapper mainMapper;
//    QUESITON 조회순 정렬
//    public List<MainDTO> findReadCount() {
//        return mainMapper.selectReadCount();
//    }

//    질문 조회수 정렬
    public List<MainDTO> findQuestionReadCount() {
        return mainMapper.selectQuestionReadCount();
    }

//    답변 정렬
    public List<MainDTO> findAnswerAll(){
        return mainMapper.selectAnswerAll();
    }

    public List<MainDTO> findAdopCount() {
        return mainMapper.selectAdoptCount();
    }

    public List<MainDTO> findVisitCount(){
        return mainMapper.selectVisitCount();
    }

    public Optional<UserVO> getUserId() {
        return mainMapper.selectUserId();
    }
}
