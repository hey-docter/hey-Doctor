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
    String type;
    String order;

    public Search(String keyword) {
        this.keyword = keyword;
    }
    public String[] getTypes() {
        return type.split("");
    }

}
