package com.heydocter.app.dao;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.dao.MainDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class MainDaoTest {
    @Autowired

    private MainDAO mainDao;

    //    커뮤니티 좋아요 순 dao 테스트
    @Test
    public void findAllTest() {
        log.info(mainDao.findAll().toString());
    }

//    답변 킹 좋아요 순 dao 테스트
    @Test
    public void findLikeDESCAllTest(){
        log.info(mainDao.findLikeDESCAll().toString());
    }
}
