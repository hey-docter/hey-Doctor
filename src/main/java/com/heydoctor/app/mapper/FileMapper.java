package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    //    파일 추가
    public void insert(FileVO fileVO);

    //    파일 삭제
    public void delete(Long fileId);

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long questionId);

    //    파일 조회
    public List<FileVO> selectAll(Long questionId);
}
