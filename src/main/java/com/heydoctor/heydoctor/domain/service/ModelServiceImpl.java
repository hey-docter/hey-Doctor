package com.heydoctor.heydoctor.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("model1") @Primary
public class ModelServiceImpl implements ModelService {
    @Override
    public void write() {

    }
}
