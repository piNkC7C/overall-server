package cn.iocoder.yudao.module.trade.framework.delivery.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 快递客户端枚举
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
public enum ExpressClientEnum {

    NOT_PROVIDE("not_provide","Not provided"),
    KD_NIAO("kd_niao", "KdNiao"),
    KD_100("kd_100", "Kuaidi100");

    /**
     * 快递服务商唯一编码
     */
    private final String code;
    /**
     * 快递服务商名称
     */
    private final String name;

}
