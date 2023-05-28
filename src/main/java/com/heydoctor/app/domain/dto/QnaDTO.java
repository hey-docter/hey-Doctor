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
public class QnaDTO {
    private Long qnaId;
    private Long userId;
    private String qnaTitle;
    private String qnaContent;
    private String qnaRegisterDateTime;
    private Boolean qnaIsPublic;
    private String userEmail;
    private String userName;
    private String answerCount;

    private List<FileVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
