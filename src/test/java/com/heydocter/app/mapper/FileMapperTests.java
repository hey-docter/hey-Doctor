package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.FileType;
import com.heydoctor.app.domain.vo.FileVO;
import com.heydoctor.app.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class FileMapperTests {

    @Autowired
    private FileMapper fileMapper;

    @Test
    public void insertTest(){
        FileVO fileVO = new FileVO();
        fileVO.setFileName("이짱.png");
        fileVO.setFileSize(1231L);
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFilePath("2023/05/13");
        fileVO.setFileType(FileType.REPRESENTATIVE.name());
        fileMapper.insert(fileVO);
    }

    @Test
    public void selectAllTest(){
        fileMapper.selectAll(22L).stream().map(FileVO::toString).forEach(log::info);
    }
//
//    @Test
//    public void deleteTest(){
//        fileMapper.delete(1L);
//        assertThat(fileMapper.selectAll(22L)).hasSize(0);
//    }
//
//    @Test
//    public void deleteAllTest(){
//        fileMapper.deleteAll(22L);
//        assertThat(fileMapper.selectAll(22L)).hasSize(0);
//    }
}
