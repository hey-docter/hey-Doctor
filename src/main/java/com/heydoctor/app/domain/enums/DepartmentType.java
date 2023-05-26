package com.heydoctor.app.domain.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * '전체',
 * '비뇨기과',
 * '산부인과',
 * '소아청소년과',
 * '안과', <p><p>
 * '이비인후과',
 * '정신건강의학과',
 * '정형외과',
 * '피부과',<p><p>
 * '치과',
 * '기타'
 *
 */
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

    /**
     * DB insert 시에는 {@link #getType()} 대신 {@link #name()}을 사용하세요.
     * <p>
     * {@link #name()}은 {@link Enum}의 선언명을, {@link #getType()}은 한글명을 리턴합니다.
     *
     * @return type(한글명)
     */
    public String getType() {
        return this.type;
    }

    public static Optional<DepartmentType> getByType(String type) {
        return Arrays.stream(values()).filter(d -> d.type.equals(type)).findFirst();
    }
}