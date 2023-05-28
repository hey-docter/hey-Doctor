package com.heydoctor.app.service.loginpage;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.heydoctor.app.dao.UserDAO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.net.*;

@Service
@Slf4j
@Transactional
public class KakaoService {

    private final UserDAO userDAO;
    private final UserMapper userMapper;
//    private final ApplicationEnvironmentConfig envConfig;

    @Autowired
    public KakaoService(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    public String getKaKaoAccessToken(String code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=76a60ca6aa2dea1ac80cdec7ec6060b5");
            sb.append("&redirect_uri=http://localhost:10000/login/kakao");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            log.info("responseCode: " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body: " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            log.info("access_token: " + access_Token);
            log.info("refresh_token: " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }

    public UserVO getKakaoInfo(String token) throws Exception {
        UserVO user = null;
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            log.info("responseCode: " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body: " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            int id = element.getAsJsonObject().get("id").getAsInt();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();


            user = new UserVO();
            user.setUserLoginType("KAKAO"); // 항상 "KAKAO"로 설정

            if (!user.getUserLoginType().equals("NOMAL") && !user.getUserLoginType().equals("NAVER")) {

                user.setUserName(nickname);
                user.setUserEmail(email);
                user.setUserPassword(Integer.toString(id));

//                userMapper.kakaoUpdate(user);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }


    public void saveUser(UserVO userVO) {
        userDAO.save(userVO);
    }

    public void logoutKakao(String token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Authorization", "Bearer " + token);
            int responseCode = conn.getResponseCode();
            log.info("responseCode: " + responseCode);

            if (responseCode == 400)
                throw new RuntimeException("An error occurred during Kakao logout");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String br_line;
            String result = "";
            while ((br_line = br.readLine()) != null) {
                result += br_line;
            }
            log.info("result: ");
            log.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}