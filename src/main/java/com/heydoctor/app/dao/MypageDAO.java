package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.MainMapper;
import com.heydoctor.app.mapper.MypageMapper;
import com.heydoctor.app.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageDAO {
    private final MypageMapper mypageMapper;

    public List<QuestionVO> findQuestionAll(Integer page)
    {return mypageMapper.selectQuestionAll(page);}

    public List<AnswerDTO> findAnswerAll(Integer page)
    {return mypageMapper.selectAnswerAll(page);}

    public List<ReplyDTO> findReplyAll(Integer page)
    {return mypageMapper.selectReplyAll(page);}

}
