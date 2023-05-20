package com.heydoctor.app.domain.enums;

import lombok.Getter;

@Getter
public enum QuestionType {
    PRIVATE(false),
    PUBLIC(true);

    private final boolean isPublic;

    QuestionType(boolean isPublic) { this.isPublic = isPublic; }
}
