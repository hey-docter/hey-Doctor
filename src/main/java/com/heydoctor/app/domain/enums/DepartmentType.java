package com.heydoctor.app.domain.enums;

import lombok.Getter;

@Getter
public enum DepartmentType {
    SURGERY("외과");

    private final String type;

    DepartmentType(String type) {
        this.type = type;
    }
}