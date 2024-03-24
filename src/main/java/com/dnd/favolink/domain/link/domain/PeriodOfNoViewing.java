package com.dnd.favolink.domain.link.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PeriodOfNoViewing {
    LEVEL0(0),
    LEVEL1(7, 30),
    LEVEL2(31, 90),
    LEVEL3(91, 180),
    LEVEL4(181);

    private int start;
    private int end;

    PeriodOfNoViewing(int start, int end) {
        this.start = start;
        this.end = end;
    }

    PeriodOfNoViewing(int start) {
        this.start = start;
    }

    @JsonCreator
    public static PeriodOfNoViewing from(String periodOfViewing) {
        return PeriodOfNoViewing.valueOf(periodOfViewing.toUpperCase());
    }

    /**
     * TODO: 링크를 한 번도 찾지 않은 기간을 PeriodOfNoViewing 객체로 반환하는 메서드 구현
     * 함수형 프로그래밍 사용하기
     */
    public static PeriodOfNoViewing valueOf(int noViewingDays) {
        return null;
    }
}
