package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.MainRequestVO;
import com.heydoctor.app.domain.vo.MainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainMapper {
//    커뮤니티 좋아요 순 정렬
    public List<MainVO> selectAll();

    public List<MainVO> selectLikeCount();
}
