package com.heydoctor.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {
    String type;
    String keyword;
    String order;

    public String[] getTypes() {
        return type.split("");
    }

}