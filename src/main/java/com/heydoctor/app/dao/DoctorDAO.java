package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DoctorDAO {
    private final DoctorMapper doctorMapper;
}
