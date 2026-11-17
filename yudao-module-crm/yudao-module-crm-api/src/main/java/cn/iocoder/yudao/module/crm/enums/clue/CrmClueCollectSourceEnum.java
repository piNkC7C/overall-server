package cn.iocoder.yudao.module.crm.enums.clue;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 外部线索收集来源（对应字典 crm_customer_source 的 value）
 */
@Getter
@AllArgsConstructor
public enum CrmClueCollectSourceEnum implements ArrayValuable<String> {

    WEBSITE("website", 11, "公司官网"),
    XINGHUAN("xinghuan", 12, "星环内测");

    public static final String[] ARRAYS = Arrays.stream(values()).map(CrmClueCollectSourceEnum::getCode).toArray(String[]::new);

    /**
     * 外部收集线索写入 crm_clue.creator 时的展示文案
     */
    public static final String AUTO_COLLECT_CREATOR = "自动收集";

    private final String code;
    private final Integer dictValue;
    private final String label;

    @Override
    public String[] array() {
        return ARRAYS;
    }

    public static CrmClueCollectSourceEnum valueOfCode(String code) {
        return ArrayUtil.firstMatch(item -> item.getCode().equals(code), values());
    }

    /**
     * 是否为外部线索收集系统内置字典值（不可删除；仅超级管理员可编辑）
     */
    public static boolean isSystemBuiltinDictValue(Integer dictValue) {
        if (dictValue == null) {
            return false;
        }
        return ArrayUtil.firstMatch(item -> item.getDictValue().equals(dictValue), values()) != null;
    }

    public static boolean isSystemBuiltinDictValue(String dictValue) {
        if (dictValue == null || !NumberUtil.isInteger(dictValue)) {
            return false;
        }
        return isSystemBuiltinDictValue(Integer.valueOf(dictValue));
    }

}
