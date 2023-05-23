package com.heydoctor.app.dao;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

    //    회원 조회
    public Optional<UserVO> findById(Long userId){
        return userMapper.selectById(userId);
    }

    // 카카오 회원가입
    public void saveKakaoUser(UserVO userVO) {
        userMapper.insert(userVO);
    }
    // 사용자 정보를 DB에 저장하는 메서드
    public void saveUser(UserVO userVO) {
        // 사용자 정보를 DB에 저장하는 로직 구현
        userMapper.insert(userVO);
    }
}
