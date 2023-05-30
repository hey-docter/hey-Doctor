package com.heydoctor.app.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {

    String keyword;

    public Search(String keyword) {
        this.keyword = keyword;
    }

}
