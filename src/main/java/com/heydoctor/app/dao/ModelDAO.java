package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ModelDAO {
    private final ModelMapper modelMapper;

}
