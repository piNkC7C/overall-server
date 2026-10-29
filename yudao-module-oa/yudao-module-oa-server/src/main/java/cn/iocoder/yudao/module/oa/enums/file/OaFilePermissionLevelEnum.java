package cn.iocoder.yudao.module.oa.enums.file;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 云盘权限级别枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaFilePermissionLevelEnum implements ArrayValuable<Integer> {

    READ(1, "Read-only"),
    DOWNLOAD(2, "Download"),
    EDIT(3, "Edit"),
    MANAGE(4, "Admin");

    /**
     * 无可访问权限，仅用于权限计算，不作为可授予的权限级别
     */
    public static final int LEVEL_NONE = 0;

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaFilePermissionLevelEnum::getLevel).toArray(Integer[]::new);

    /**
     * 云盘权限级别
     */
    private final Integer level;
    /**
     * 名称
     */
    private final String name;

    /**
     * 获得权限级别枚举
     *
     * @param level 权限级别
     * @return 权限级别枚举，不存在时返回 null
     */
    public static OaFilePermissionLevelEnum valueOf(Integer level) {
        return ArrayUtil.firstMatch(item -> item.getLevel().equals(level), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
