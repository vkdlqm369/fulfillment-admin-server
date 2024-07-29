package com.daou.sabangnetserver.label.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : donghyunkim
 * @description :
 * @packageName : com.daou.sabangnetserver.label.enums
 * @fileName : ReleaseStatus
 * @date : 2024. 7. 29.
 */
public interface Release {

    @Getter
    enum ModuleCode {
        CJ2, CJ, EPOST, HANJIN, LOGEN, LOTTE, TODAY_PICKUP, VROONG, DBOX;

    }

    @Getter
    @AllArgsConstructor
    enum BoxType {
        SMALL("01", "극소"),
        MEDIUM("03", "중"),
        LARGE1("04", "대1"),
        LARGE2("07", "대2"),
        OTHER("05", "이형"),
        RESTRICTED("06", "취급제한");

        private final String code;
        private final String text;
    }

}
