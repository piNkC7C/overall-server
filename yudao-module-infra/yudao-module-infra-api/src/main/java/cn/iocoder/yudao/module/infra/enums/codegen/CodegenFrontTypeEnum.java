package cn.iocoder.yudao.module.infra.enums.codegen;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 代码生成的前端类型枚举
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum CodegenFrontTypeEnum {

    VUE2_ELEMENT_UI(10), // Vue2 Element UI standard template

    VUE3_ELEMENT_PLUS(20), // Vue3 Element Plus standard template

    VUE3_VBEN2_ANTD_SCHEMA(30), // Vue3 VBEN2 + ANTD + Schema template

    VUE3_VBEN5_ANTD_SCHEMA(40), // Vue3 VBEN5 + ANTD + schema template
    VUE3_VBEN5_ANTD_GENERAL(41), // Vue3 VBEN5 + ANTD standard template

    VUE3_VBEN5_ANTDV_NEXT_SCHEMA(42), // Vue3 VBEN5 + Antdv Next + schema template
    VUE3_VBEN5_ANTDV_NEXT_GENERAL(43), // Vue3 VBEN5 + Antdv Next standard template

    VUE3_VBEN5_EP_SCHEMA(50), // Vue3 VBEN5 + EP + schema template
    VUE3_VBEN5_EP_GENERAL(51), // Vue3 VBEN5 + EP standard template

    VUE3_ADMIN_UNIAPP_WOT(60), // Vue3 Admin + Uniapp + WOT standard template
    ;

    /**
     * 类型
     */
    private final Integer type;

}
