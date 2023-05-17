package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;
}
