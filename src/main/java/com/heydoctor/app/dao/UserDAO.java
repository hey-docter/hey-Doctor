package com.heydoctor.app.dao;

import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.QuestionMapper;
import com.heydoctor.app.mapper.ReplyMapper;
import com.heydoctor.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    //    아이디 중복검사
    public Optional<UserVO> findByUserEmail(String userEmail){
        return userMapper.selectByUserEmail(userEmail);
    }

    //    회원가입
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

    //    로그인
    public Optional<Long> findByUserEmailAndUserPassword(String userEmail, String userPassword){
        return userMapper.selectByUserEmailAndUserPassword(userEmail, userPassword);
    }

    //    게시글 목록
    public List<QuestionVO> findAll(){
        return QuestionMapper.selectAll();
    }

    //    댓글 목록
    public List<ReplyVO> findAll(){
        return ReplyMapper.selectAll();
    }
}
