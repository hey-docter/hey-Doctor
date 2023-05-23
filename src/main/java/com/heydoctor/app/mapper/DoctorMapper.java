package com.heydoctor.app.mapper;

import com.heydoctor.app.domain.vo.DoctorVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorMapper {
    public void insert(DoctorVO doctorVO);
}
