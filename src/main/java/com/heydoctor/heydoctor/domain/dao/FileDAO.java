package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;
}
