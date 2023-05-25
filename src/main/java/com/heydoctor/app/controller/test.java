//package com.heydoctor.app.controller;
//
//public class test {
//    public String loginGETNaver(HttpSession session, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
//
//        // 사용자 정보를 활용하여 DB 조회
//        UserVO newUser = new UserVO();
//        Optional<UserVO> existingUserOptional = loginPageService.checkEmail(email);
//
//        log.info("New: {}",existingUserOptional);
//
//
//        if (existingUserOptional.isPresent()) {
//            if (existingUserOptional.get().getUserLoginType().equals("KAKAO")){
//                return "/login/login";
//            }
//            else{
//                userMapper.naverUpdate(newUser);
//                Optional<UserVO> newid = loginPageService.checkEmail(email);
//                session.setAttribute("id", newid.get().getUserId());
//                return "/main-page-main-page";
//            }
//        }
//        // DB에 사용자 등록
//        // 회원가입 메서드 호출
//        newUser.setUserLoginType("NAVER");
//        newUser.setUserEmail(email);
//        newUser.setUserName(name);
//        newUser.setUserPassword(id);
//        log.info("New user email: {}", newUser.getUserEmail());
//        log.info("New user name: {}", newUser.getUserName());
//        log.info("New user id: {}", newUser.getUserPassword());
//        log.info("세션: {}", id);
//        loginPageService.join(newUser);
//
////                Optional<UserVO> newid = loginPageService.checkEmail(email);
////                session.setAttribute("id", newid.get().getUserId());
//        return "/main-page/main-page";
//
//    }
//
//}
