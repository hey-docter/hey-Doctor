package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    public List<MainDTO> selectReadCount();

    //    답변 왕 조회
    public List<MainDTO> selectAdoptCount();

    public List<MainDTO> selectVisitCount();
}
