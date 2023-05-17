package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.CareerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CarrerDAO {
private final CareerMapper careerMapper;
}
