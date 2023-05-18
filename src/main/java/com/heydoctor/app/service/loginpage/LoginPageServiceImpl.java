package com.heydoctor.app.service.loginpage;

import com.heydoctor.app.dao.UserDAO;
import com.heydoctor.app.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginPageServiceImpl implements LoginPageService {
    private final UserDAO userDAO;

    @Override
    public Optional<UserVO> checkEmail(String userEmail){
        return userDAO.findByUserEmail(userEmail);
    }

    @Override
    public void join(UserVO userVO){
        userDAO.save(userVO);
    }

    @Override
    public Optional<Long> login(String userEmail, String userPassword){
        return userDAO.findByUserEmailAndUserPassword(userEmail, userPassword);
    }
}
