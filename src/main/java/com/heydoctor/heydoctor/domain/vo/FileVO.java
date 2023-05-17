package com.heydoctor.heydoctor.domain.vo;

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


}
