package cn.iocoder.yudao.module.system.enums.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单类型枚举类
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

    DIR(1), // Directory
    MENU(2), // Menu
    BUTTON(3) // Button
    ;

    /**
     * 类型
     */
    private final Integer type;

}
