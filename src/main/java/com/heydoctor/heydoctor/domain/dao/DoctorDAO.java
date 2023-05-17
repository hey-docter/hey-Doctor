package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DoctorDAO {
    private final DoctorMapper doctorMapper;
}
