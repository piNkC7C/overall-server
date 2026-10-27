package cn.iocoder.yudao.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档地址
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {

    REDIS_INSTALL("https://gitee.com/zhijiantianya/ruoyi-vue-pro/issues/I4VCSJ", "Redis setup guide"),
    TENANT("https://doc.iocoder.cn", "SaaS multi-tenant guide");

    private final String url;
    private final String memo;

}
