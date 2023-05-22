package com.heydoctor.app.service.mainpage;

import com.heydoctor.app.domain.vo.MainVO;

import java.util.List;

public interface MainPageService {
    //    커뮤니티 좋아요 순 정렬
    public List<MainVO> getListAll();

//    답변 킹 좋아요 순 정렬
    public List<MainVO> getListLikeDESCAll();
}
