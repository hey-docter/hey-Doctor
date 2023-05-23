package com.heydoctor.app.dao;

import com.heydoctor.app.domain.vo.FileVO;
import com.heydoctor.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    //    파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }

    //    파일 삭제
    public void delete(Long fileId){
        fileMapper.delete(fileId);
    }

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long questionId){
        fileMapper.deleteAll(questionId);
    }

    //    파일 조회
    public List<FileVO> findAll(Long questionId){
        return fileMapper.selectAll(questionId);
    }
}
