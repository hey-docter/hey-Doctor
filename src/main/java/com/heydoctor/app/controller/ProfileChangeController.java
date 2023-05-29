package com.heydoctor.app.controller;

import com.heydoctor.app.dao.UserDAO;
import com.heydoctor.app.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/files/*")
public class ProfileChangeController {
    private final UserDAO userDAO;
    private static final String path = "/Users/gimjin/Desktop/web_1900_hds/spring/workspace/hey/src/main/resources/static/image/profiles/";

    public ProfileChangeController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("profileImage")
    public byte[] getProfileImage(String userProfileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("/Users/gimjin/Desktop/web_1900_hds/spring/workspace/hey/src/main/resources/static/image/profiles/", userProfileName)); // 기본 이미지 URL 반환
    }

    public String getPath() { return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); }

    @PostMapping("upload")
    public String updateProfile(@RequestParam("imgFile") MultipartFile imgFile, HttpSession session) {
        Long userId = 1L;//(Long) session.getAttribute("userId");  // 세션에서 사용자 ID 가져오기

        // 세션으로부터 가져온 사용자 ID로 DB에서 사용자 정보 조회
        Optional<UserVO> existingUserOptional = userDAO.findById(userId);
        String path = "/Users/gimjin/Desktop/web_1900_hds/spring/workspace/hey/src/main/resources/static/image/profiles/";
        UUID uuid = UUID.randomUUID();
        // 사용자 정보가 존재하면 업데이트 진행
        existingUserOptional.ifPresent(userVO -> {

            try {
                imgFile.transferTo(new File(path,  uuid.toString() + "_" + imgFile.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            userVO.setUserProfileUuid(uuid.toString());
            userVO.setUserProfileName(imgFile.getOriginalFilename());

            userDAO.updateProfile(userVO);
        });
        return uuid.toString();
    }

    @GetMapping("display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(path + fileName));
    }



// 파일 업로드
//    @PostMapping("/files/upload")
//    @ResponseBody
//    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
//        String path = "/Users/gimjin/Desktop/test";
//        String uuid = UUID.randomUUID().toString();
//        File file = new File(path);
//
//        log.info("프로필1");
//
//        String originalFilename = uploadFile.getOriginalFilename();
//        String savedFilename = uuid + "_" + originalFilename;
//        uploadFile.transferTo(new File(path, savedFilename));
//
//        if (uploadFile.getContentType().startsWith("image")) {
//            File thumbnailFile = new File(path, "t_" + savedFilename);
//            try (FileOutputStream out = new FileOutputStream(thumbnailFile)) {
//                Thumbnailator.createThumbnail(uploadFile.getInputStream(), out, 100, 100);
//            }
//        }
//
//        return uuid;
//    }
}




