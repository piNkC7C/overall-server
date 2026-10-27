package cn.iocoder.yudao.module.infra.enums.logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 异常数据的处理状态
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum ApiErrorLogProcessStatusEnum {

    INIT(0, "Not process."),
    DONE(1, "Already process."),
    IGNORE(2, "Ignored");

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 资源类型名
     */
    private final String name;

}
