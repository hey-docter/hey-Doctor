package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.HospitalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HospitalDAO {
    private final HospitalMapper hospitalMapper;
}
