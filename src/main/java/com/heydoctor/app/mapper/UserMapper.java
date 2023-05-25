package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {

    //    email 중복검사
    public Optional<UserVO> selectByUserEmail(String userEmail);

    //    회원가입
    public void insert(UserVO userVO);

    //    로그인
    @Select("SELECT USER_ID FROM TBL_USER WHERE USER_EMAIL = #{userEmail} AND USER_PASSWORD = #{userPassword}")
    public Optional<Long> selectByUserEmailAndUserPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    //    회원 조회
    public Optional<UserVO> selectById(Long userId);

    // 카카오 값 변경
    public void kakaoUpdate(UserVO userVO);

    // 네이버 값 변경
    public void naverUpdate(UserVO userVO);
}
