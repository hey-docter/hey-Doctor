package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.CareerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CarrerDAO {
private final CareerMapper careerMapper;
}
