package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.MainMapper;
import com.heydoctor.app.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MypageDAO {
    private final MypageMapper mypageMapper;



}
