package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileVO {
  private Long fileId;
  private Long fileSize;
  private String fileOriginName;
  private String fileUuid;
  private String filePath;
  private String fileType;
  private String fileName;
  private Long questionId;
}

