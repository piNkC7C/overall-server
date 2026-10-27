package cn.iocoder.yudao.module.hrm.enums.employee.config;

import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HRM 员工档案字段枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeArchiveFieldEnum {

    NAME("name", "Employee Name", "Basic Info", true, true, false),
    COUNTRY("country", "Country / Region", "Basic Info", true, true, false),
    NATION("nation", "Ethnicity", "Basic Info", true, true, false),
    ID_TYPE("idType", "ID Type", "Basic Info", true, true, false),
    ID_NUMBER("idNumber", "ID Number", "Basic Info", true, true, false),
    SEX("sex", "Gender", "Basic Info", true, true, false),
    NATIVE_PLACE("nativePlace", "Hometown", "Basic Info", true, true, false),
    BIRTHDAY("birthday", "Date of birth", "Basic Info", true, true, false),
    AGE("age", "Age", "Basic Info", true, false, true),
    HIGHEST_EDUCATION("highestEducation", "Highest Education", "Basic Info", true, true, false),

    MOBILE("mobile", "Phone number.", "Contact info", true, true, false),
    EMAIL("email", "Email", "Contact info", true, true, false),
    ADDRESS("address", "Household Address", "Contact info", true, true, false);

    /**
     * 字段名称
     */
    private final String name;
    /**
     * 字段标题
     */
    private final String title;
    /**
     * 字段分组名称
     */
    private final String groupName;
    /**
     * 默认是否显示
     */
    private final Boolean defaultVisible;
    /**
     * 默认是否允许员工编辑
     */
    private final Boolean defaultEditable;
    /**
     * 是否锁定编辑
     */
    private final Boolean editableLocked;

    public static HrmEmployeeArchiveFieldEnum valueOfName(String name) {
        return ArrayUtil.firstMatch(item -> item.getName().equals(name), values());
    }

}
