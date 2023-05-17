package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.HospitalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HospitalDAO {
    private final HospitalMapper hospitalMapper;
}
