package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MainVO {
    private Long id;
    private Long userId;
    private Long likeCount;
    private Long readCount;
    private String title;
    private String content;
    private String registerDate;
    private String departmentType;

}
