package com.heydoctor.app.controller;

import com.heydoctor.app.dao.UserDAO;
import com.heydoctor.app.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Controller
@Slf4j
public class ProfileChangeController {
    private final UserDAO userDAO;
    private boolean isUpdatingProfile = false;  // 프로필 업데이트 중 여부를 나타내는 변수

    public ProfileChangeController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @GetMapping("/files/profileImage")
    @ResponseBody
    public String getProfileImage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");  // 세션에서 사용자 ID 가져오기

        // 세션으로부터 가져온 사용자 ID로 DB에서 사용자 정보 조회
        Optional<UserVO> existingUserOptional = userDAO.findById(userId);

        if (existingUserOptional.isPresent()) {
            UserVO existingUser = existingUserOptional.get();
            String imageUrl = existingUser.getUserProfilePath();

            if (imageUrl != null) {
                return imageUrl;
            }
        }

        return "https://cdn.comento.kr/images/illust/illust-photo-upload.svg"; // 기본 이미지 URL 반환
    }


    @PostMapping("/files/upload")
    @ResponseBody
    public synchronized Object updateProfile(@ModelAttribute UserVO userVO, @RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");  // 세션에서 사용자 ID 가져오기

        // 세션으로부터 가져온 사용자 ID로 DB에서 사용자 정보 조회
        Optional<UserVO> existingUserOptional = userDAO.findById(userId);

        // 사용자 정보가 존재하면 업데이트 진행
        if (existingUserOptional.isPresent()) {
            UserVO existingUser = existingUserOptional.get();

            // 모든 필드 값을 가져와서 userVO 객체에 설정
            userVO.setUserId(existingUser.getUserId());
            userVO.setUserEmail(existingUser.getUserEmail());
            userVO.setUserLoginType(existingUser.getUserLoginType());
            userVO.setUserName(existingUser.getUserName());
            userVO.setUserIsAvailable(existingUser.getUserIsAvailable());
            userVO.setUserPassword(existingUser.getUserPassword());
            userVO.setUserType(existingUser.getUserType());

            // 프로필 이미지 업로드 처리
            String uploadPath = "/Users/gimjin/Desktop/web_1900_hds/spring/workspace/hey/src/main/resources/static/image/profiles";
            String fileName = UUID.randomUUID().toString() + "_" + imgFile.getOriginalFilename();
            File profileImg = new File(uploadPath + File.separator + fileName);

            imgFile.transferTo(profileImg);

            // 업로드한 이미지 정보를 UserVO에 설정
            String imageUrl = "/image/profiles/" + fileName;
            userVO.setUserProfilePath(imageUrl);
            String updatedFileName = profileImg.getName();
            userVO.setUserProfileName(updatedFileName);
            userVO.setUserProfileSize(imgFile.getSize());
            userVO.setUserProfileType(imgFile.getContentType());
            userVO.setUserProfileUuid(UUID.randomUUID().toString());

            // 파일을 복사하여 영구적인 저장소에 저장
            Path destination = Paths.get("/Users/gimjin/Desktop/web_1900_hds/spring/workspace/hey/src/main/resources/static/image/profiles/" + File.separator + fileName);
            Files.copy(profileImg.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

            log.info("프로필 업데이트");
            log.info(String.valueOf(userVO));

            // DB 업데이트
            userDAO.updateProfile(userVO);

            return userVO.getUserProfileUuid();
        }

        // 사용자 정보를 찾을 수 없는 경우에 대한 예외 처리

        return null;
    }

}





