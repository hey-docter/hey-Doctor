package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
//    public List<MainDTO> selectReadCount();

//    질문 조회수 정렬

    public List<MainDTO> selectQuestionReadCount();

//    답변 정렬

    public List<MainDTO> selectAnswerAll();

    //    답변 왕 조회
    public List<MainDTO> selectAdoptCount();

    public List<MainDTO> selectVisitCount();
}
