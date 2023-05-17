package com.heydoctor.heydoctor.user.domain.dao;

import com.heydoctor.heydoctor.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ModelDAO {
    private final ModelMapper modelMapper;

}
