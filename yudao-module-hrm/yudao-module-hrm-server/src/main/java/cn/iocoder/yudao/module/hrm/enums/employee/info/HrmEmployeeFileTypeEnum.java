package cn.iocoder.yudao.module.hrm.enums.employee.info;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工材料附件类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeFileTypeEnum implements ArrayValuable<Integer> {

    ID_CARD_ORIGINAL(11, "ID photo"),
    EDUCATION_CERTIFICATE(12, "Education proof"),
    PROFILE_PHOTO(13, "Headshot"),
    ID_CARD_COPY(14, "ID copy"),
    SALARY_BANK_CARD(15, "Payroll bank card"),
    SOCIAL_SECURITY_CARD(16, "Social-security card"),
    HOUSING_FUND_CARD(17, "Housing-fund card"),
    AWARD_CERTIFICATE(18, "Award certificate"),
    BASIC_OTHER(19, "Other basic files"),
    LABOR_CONTRACT(21, "Labor contract"),
    ENTRY_RESUME(22, "Onboarding resume"),
    ENTRY_REGISTRATION(23, "Onboarding form"),
    ENTRY_MEDICAL_REPORT(24, "Pre-employment physical"),
    PREVIOUS_LEAVE_CERTIFICATE(25, "Previous employer release letter"),
    REGULAR_APPLICATION(26, "Confirmation form"),
    ARCHIVE_OTHER(27, "Other archive files"),
    LEAVE_APPROVAL(31, "Offboarding approval"),
    LEAVE_CERTIFICATE(32, "Release letter"),
    LEAVE_OTHER(33, "Other offboarding files");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeFileTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmEmployeeFileTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}
