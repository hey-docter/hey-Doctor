package com.heydoctor.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;

@Controller
@RequiredArgsConstructor
@Slf4j
public class naver2Controller {

    private String CLIENT_ID = "0QEJy5lMTxel75jSVhqm"; //애플리케이션 클라이언트 아이디값";
    private String CLI_SECRET = "09W0c4sAE4"; //애플리케이션 클라이언트 시크릿값";


    @RequestMapping(value="login/naver", method= RequestMethod.GET)
    public String loginPOSTNaver(Model model, HttpSession session)throws UnsupportedEncodingException, UnknownHostException {
        log.info("callback controller");
        String redirectURI = URLEncoder.encode("http://localhost:10000", "UTF-8");
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString();
        String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
        apiURL += String.format("&client_id=%s&redirect_uri=%s&state=%s",
                CLIENT_ID, redirectURI, state);
        model.addAttribute("apiURL", apiURL);
        return "/login/callback";
    }
}
