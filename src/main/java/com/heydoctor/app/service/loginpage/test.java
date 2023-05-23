//package com.app.floc.service.user;
//
//import com.app.floc.domain.VO.UserVO;
//import lombok.extuserServiceern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import com.google.gson.JsonParser;
//import com.google.gson.JsonElement;
//
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Optional;
//
//@Service
//@Slf4j
//public class KaKaoService {
//
//    public String getKaKaoAccessToken(String code){
//        String access_Token="";
//        String refresh_Token ="";
//        String reqURL = "https://kauth.kakao.com/oauth/token";
//
//        try{
//            URL url = new URL(reqURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//
//            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//            StringBuilder sb = new StringBuilder();
//            sb.append("grant_type=authorization_code");
//            sb.append("&client_id=0a0d62970720c0f5877d5c69122ba110"); // TODO REST_API_KEY 입력
//            sb.append("&redirect_uri=http://localhost:10000/user/login-kakao"); // TODO 인가코드 받은 redirect_uri 입력
//            sb.append("&code=" + code);
//            bw.write(sb.toString());
//            bw.flush();
//
//            //결과 코드가 200이라면 성공
//            int responseCode = conn.getResponseCode();
//            log.info("responseCode : " + responseCode);
//            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line = "";
//            String result = "";
//
//            while ((line = br.readLine()) != null) {
//                result += line;
//            }
//            log.info("response body : " + result);
//
//            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(result);
//
//            access_Token = element.getAsJsonObject().get("access_token").getAsString();
//            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
//
//            log.info("access_token : " + access_Token);
//            log.info("refresh_token : " + refresh_Token);
//
//            br.close();
//            bw.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return access_Token;
//    }
//
//    public UserVO getKakaoInfo(String token) throws Exception {
//
//        String reqURL = "https://kapi.kakao.com/v2/user/me";
//        String result = "";
//        //access_token을 이용하여 사용자 정보 조회
//        try {
//            URL url = new URL(reqURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송
//
//            //결과 코드가 200이라면 성공
//            int responseCode = conn.getResponseCode();
//            log.info("responseCode : " + responseCode);
//
//            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line = "";
//
//            while ((line = br.readLine()) != null) {
//                result += line;
//            }
//            log.info("response body : " + result);
//
//            //Gson 라이브러리로 JSON파싱
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(result);
//
//            String password = element.getAsJsonObject().get("id").getAsString();
//            boolean emailNeedsAgreement = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email_needs_agreement").getAsBoolean();
//            //이메일 비동의 시 널 리턴
//            if(emailNeedsAgreement){
//                return null;
//            }
//            String email = "";
//            email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
//            String nickname ="";
//            nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
//            //고유번호 -> 비밀번호
//            //email -> identification
//            //
//
//            UserVO userVO = new UserVO();
//            userVO.setUserName(nickname);
//            userVO.setUserPassword(password);
//            userVO.setUserNickname(nickname);
//            userVO.setUserIdentification(email);
//            userVO.setUserAlarm("AGREE");
//            userVO.setUserMarketing("AGREE");
//            userVO.setUserStatus("KAKAO");
//            br.close();
//            return userVO;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //모든 정보를 담은 스트링 리턴
//        return null;
//    }
//
//    public void logoutKakao(String token){
//        String reqURL ="https://kapi.kakao.com/v1/user/logout";
//        try {
//            URL url = new URL(reqURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//
//            conn.setRequestProperty("Authorization", "Bearer " + token);
//            int responseCode = conn.getResponseCode();
//            log.info("responseCode : " + responseCode);
//
//            if(responseCode ==400)
//                throw new RuntimeException("카카오 로그아웃 도중 오류 발생");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//            String br_line = "";
//            String result = "";
//            while ((br_line = br.readLine()) != null) {
//                result += br_line;
//            }
//            log.info("결과");
//            log.info(result);
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//    @GetMapping("/login-kakao")
//    public RedirectView  kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
//        String token = kakaoService.getKaKaoAccessToken(code);
//        Optional<UserVO> kakaoUser = Optional.ofNullable(kakaoService.getKakaoInfo(token));
//
//        //카카오 로그인에서 빈객체 전송 -> 무언가 문제가 발생 ->실패로 로그인창
//        if(kakaoUser.isEmpty()){
//            redirectAttributes.addFlashAttribute("login","fail-kakao-non-email");
//            return new RedirectView("/user/login");
//        }
//
//        //카카오 로그인 성공시 받아온 아이디로 디비조회
//        Optional<UserVO> foundUser = userService.checkId(kakaoUser.get().getUserIdentification());
//
//        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 노말인경우)
//        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 naver인경우)
//        //디비조회한 아이디가 있고 status가 카카오인경우 -> 로그인진행 밑 받아온 데이터로 업데이트)
//        if(foundUser.isPresent()){
//            if(foundUser.get().getUserStatus().equals("NORMAL")){
//
//                redirectAttributes.addFlashAttribute("login","already-exist-NORMAL");
//                return new RedirectView("/user/login");
//            }else if(foundUser.get().getUserStatus().equals("NAVER")){
//                redirectAttributes.addFlashAttribute("login","already-exist-NAVER");
//                return new RedirectView("/user/login");
//            }else{   //네이버, 노말아닌 카카오 계정일경우 -> update
//                kakaoUser.get().setId(foundUser.get().getId());
//                log.info(kakaoUser.get().toString());
//                userService.modifyUser(kakaoUser.get());
//                session.setAttribute("token", token);
//                session.setAttribute("userId",foundUser.get().getId());
//                return new RedirectView("/main/main");
//
//            }
//        }
//        //중복된 아이디가 없이 로그인 시도 -> db에 인서트
//        userService.join(kakaoUser.get());
//
//        //인서트 이후 바로 세션아이디, 토큰 받고 메인페이지로
//        Optional<Long> foundId = userService.login(kakaoUser.get().getUserIdentification(), kakaoUser.get().getUserPassword());
//        session.setAttribute("userId",foundId.get());
//        session.setAttribute("token", token);
//        return new RedirectView("/main/main");
//    }