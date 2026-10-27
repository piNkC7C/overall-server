package cn.iocoder.yudao.module.system.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别的枚举值
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum SexEnum {

    /** Male*/
    MALE(1),
    /** Female*/
    FEMALE(2),
    /* Unknown*/
    UNKNOWN(0);

    /**
     * 性别
     */
    private final Integer sex;

}
