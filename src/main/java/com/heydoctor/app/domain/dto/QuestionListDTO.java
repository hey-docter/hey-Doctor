package com.heydoctor.app.domain.dto;

import com.heydoctor.app.domain.vo.FileVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class QuestionListDTO {
    private Long questionId;
    private Long userId;
    private String questionTitle;
    private String questionContent;
    private String questionRegisterDatetime;
    private Boolean questionIsPublic;
    private Long questionLikeCount;
    private String doctorDepartmentType;
    private Integer readCount;
    private Integer bookmarkedCount;

    private String userName;

    private Integer answerCount;
    private List<FileVO> files = new ArrayList<>();

    private List<Long> fileIdsForDelete = new ArrayList<>();

}
