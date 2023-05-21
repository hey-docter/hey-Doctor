package com.heydoctor.app.domain.enums;

import lombok.Getter;

/**
 * '전체',
 * '비뇨기과',
 * '산부인과',
 * '소아청소년과',
 * '안과',
 * '이비인후과',
 * '정신건강의학과',
 * '정형외과',
 * '피부과',
 * '치과',
 * '기타'
 */
@Getter
public enum DepartmentType {
    ALL("전체"),
    UROLOGY("비뇨기과"),
    OBSTETRICS_AND_GYNECOLOGY("산부인과"),
    PEDIATRICS("소아청소년과"),
    EYE_CLINIC("안과"),
    ENT_CLINIC("이비인후과"),
    MENTAL_HEALTH("정신건강의학과"),
    ORTHOPEDICS("정형외과"),
    DERMATOLOGY("피부과"),
    DENTIST("치과"),
    OTHERS("기타")
    ;

    private final String type;

    DepartmentType(String type) {
        this.type = type;
    }
}