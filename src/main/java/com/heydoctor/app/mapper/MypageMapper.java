package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MypageMapper {
    //    질문 게시글 목록
    public List<QuestionVO> selectList(Integer page);



}
