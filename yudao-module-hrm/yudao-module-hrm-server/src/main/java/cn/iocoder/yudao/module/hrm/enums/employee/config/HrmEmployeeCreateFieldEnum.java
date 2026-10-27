package cn.iocoder.yudao.module.hrm.enums.employee.config;

import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeEntryStatusEnum;
import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HRM 新建员工字段枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeCreateFieldEnum {

    NAME("name", "Employee Name", "Person info.", true, true, true, true),
    USER_ID("userId", "Bind user.", "Person info.", true, false, true, false),
    MOBILE("mobile", "Phone number.", "Person info.", true, true, true, true),
    EMAIL("email", "Email", "Person info.", true, false, true, false),
    COUNTRY("country", "Country / Region", "Person info.", false, false, false, false),
    NATION("nation", "Ethnicity", "Person info.", false, false, false, false),
    ID_TYPE("idType", "ID Type", "Person info.", true, false, true, false),
    ID_NUMBER("idNumber", "ID Number", "Person info.", true, false, true, false),
    SEX("sex", "Gender", "Person info.", true, false, true, false),
    NATIVE_PLACE("nativePlace", "Hometown", "Person info.", false, false, false, false),
    BIRTHDAY("birthday", "Date of birth", "Person info.", false, false, false, false),
    AGE("age", "Age", "Person info.", false, false, false, false),
    HIGHEST_EDUCATION("highestEducation", "Highest Education", "Person info.", false, false, false, false),
    ADDRESS("address", "Household Address", "Person info.", false, false, false, false),

    JOB_NUMBER("jobNumber", "Employee No", "Onboarding info.", true, true, false, false),
    ENTRY_STATUS("entryStatus", "Onboarding status.", "Onboarding info.", true, true, true, true),
    DEPT_ID("deptId", "Department.", "Onboarding info.", true, false, true, false),
    POST_NAME("postName", "Job Title name.", "Onboarding info.", true, false, true, false),
    POST_LEVEL("postLevel", "Job Grade", "Onboarding info.", false, false, false, false),
    LEADER_EMPLOYEE_ID("leaderEmployeeId", "Direct Manager", "Onboarding info.", true, false, true, false),
    CHANNEL_ID("channelId", "Recruiting Channel", "Onboarding info.", false, false, false, false),
    TYPE("type", "Employment Type", "Onboarding info.", true, true, true, true),
    STATUS("status", "Employee status.", "Onboarding info.", true, true, true, true),
    ENTRY_TIME("entryTime", "Hire Date", "Onboarding info.", true, true, true, true),
    PROBATION("probation", "Probation period (Month)", "Onboarding info.", true, true, true, true),
    REGULAR_TIME("regularTime", "Confirmation Date", "Onboarding info.", false, false, false, false),
    LEAVE_TIME("leaveTime", "Offboarding time.", "Onboarding info.", false, false, false, false),
    COMPANY_AGE_START_TIME("companyAgeStartTime", "Tenure start date", "Onboarding info.",
            false, false, false, false),
    COMPANY_AGE("companyAge", "tenure (Year)", "Onboarding info.", false, false, false, false),
    WORK_CITY("workCity", "Work City", "Onboarding info.", true, false, true, false),
    WORK_ADDRESS("workAddress", "Work Location", "Onboarding info.", false, false, false, false),
    WORK_DETAIL_ADDRESS("workDetailAddress", "Detailed work address", "Onboarding info.",
            false, false, false, false),
    CANDIDATE_ID("candidateId", "Recruitingcandidate.", "Onboarding info.", false, false, false, false),
    REMARK("remark", "Notes.", "Onboarding info.", true, false, true, false);

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
     * 在职办理时默认是否显示
     */
    private final Boolean activeDefaultVisible;
    /**
     * 在职办理时是否锁定显示
     */
    private final Boolean activeVisibleLocked;
    /**
     * 待入职办理时默认是否显示
     */
    private final Boolean pendingEntryDefaultVisible;
    /**
     * 待入职办理时是否锁定显示
     */
    private final Boolean pendingEntryVisibleLocked;

    public static HrmEmployeeCreateFieldEnum valueOfName(String name) {
        return ArrayUtil.firstMatch(item -> item.getName().equals(name), values());
    }

    /**
     * 获得指定入职状态的默认显隐值
     *
     * @param entryStatus 入职状态
     * @return 默认是否显示
     */
    public Boolean getDefaultVisible(Integer entryStatus) {
        return HrmEmployeeEntryStatusEnum.ACTIVE.getStatus().equals(entryStatus)
                ? activeDefaultVisible : pendingEntryDefaultVisible;
    }

    /**
     * 获得指定入职状态的锁定显示值
     *
     * @param entryStatus 入职状态
     * @return 是否锁定显示
     */
    public Boolean getVisibleLocked(Integer entryStatus) {
        return HrmEmployeeEntryStatusEnum.ACTIVE.getStatus().equals(entryStatus)
                ? activeVisibleLocked : pendingEntryVisibleLocked;
    }

}
