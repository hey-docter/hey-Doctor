package com.heydoctor.app.dao;

import com.heydoctor.app.mapper.PayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PayDAO {
    private final PayMapper pay;
}
