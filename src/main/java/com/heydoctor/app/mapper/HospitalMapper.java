package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.HospitalVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalMapper {
    public void insert(HospitalVO hospitalVO);
}
