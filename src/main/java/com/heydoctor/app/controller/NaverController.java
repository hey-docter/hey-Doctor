package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NaverController {

    @Autowired
    private LoginPageService loginPageService;
    private final UserMapper userMapper;


    @GetMapping("/login/navera")
    @ResponseBody
    public String joinNaver(@RequestParam(value="email", required=false) String email,@RequestParam(value="name", required=false)String name,@RequestParam(value="id", required=false) String id, HttpSession session) {
        log.info("들옴");
        UserVO userVO = new UserVO();
        userVO.setUserEmail(email);
        userVO.setUserPassword(id);
        userVO.setUserName(name);



        Optional<UserVO> foundId = loginPageService.checkEmail(email);
        if(foundId.isPresent()){
            if (foundId.get().getUserLoginType().equals("KAKAO") || foundId.get().getUserLoginType().equals("NOMAL") ) {
                return "/login/login";
            }else{
                userMapper.naverUpdate(userVO);
                Optional<UserVO> newid = loginPageService.checkEmail(email);
                session.setAttribute("id", newid.get().getUserId());
                log.info("로그인되면서 업데이트됨");
                log.info("세션: {}", newid.get().getUserId());
                return "/main-page/main-page";
            }
        }
        userVO.setUserLoginType("NAVER");
        loginPageService.join(userVO);
        Optional<UserVO> newid2 = loginPageService.checkEmail(email);
        session.setAttribute("id",newid2.get().getUserId());
        log.info("회원가입됨");
        return "/main-page/main-page";
    }







//    @GetMapping("/login/naver")
//    public String loginGETNaver(HttpSession session, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
//
//        Optional<UserVO> existingUserOptional = loginPageService.checkEmail(email);
//        UserVO newUser = new UserVO();
//
//        if (email != null && name != null) {
//
//
//            // 사용자 정보를 활용하여 DB 조회
//            //이메일이 없을 경우 DB 추가
//            if (!existingUserOptional.isPresent()) {
//                // DB에 사용자 등록
//                newUser.setUserEmail(email);
//                newUser.setUserName(name);
//                newUser.setUserPassword(id);
//                newUser.setUserLoginType("NAVER");
//                log.info("New user email: {}", newUser.getUserEmail());
//                log.info("New user name: {}", newUser.getUserName());
//                log.info("New user id: {}", newUser.getUserPassword());
//                log.info("세션: {}", newUser.getUserId());
//                loginPageService.join(newUser); // 회원가입 메서드 호출
//            } else {
//                //업데이트
//                userMapper.naverUpdate(newUser);
//            }
//
//            // 프로필 데이터를 세션에 저장
//            session.setAttribute("id", existingUserOptional.get().getUserId());
//        }
//        // 세션을 활용한 다른 처리 로직 수행
//        return "login/callback";
//    }
}
