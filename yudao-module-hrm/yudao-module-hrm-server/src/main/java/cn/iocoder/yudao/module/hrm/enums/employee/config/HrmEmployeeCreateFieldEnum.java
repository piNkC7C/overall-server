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

    NAME("name", "Employee name", "Personal details", true, true, true, true),
    USER_ID("userId", "Linked user", "Personal details", true, false, true, false),
    MOBILE("mobile", "Mobile number", "Personal details", true, true, true, true),
    EMAIL("email", "Email", "Personal details", true, false, true, false),
    COUNTRY("country", "Country / Region", "Personal details", false, false, false, false),
    NATION("nation", "Ethnicity", "Personal details", false, false, false, false),
    ID_TYPE("idType", "ID Type", "Personal details", true, false, true, false),
    ID_NUMBER("idNumber", "ID Number", "Personal details", true, false, true, false),
    SEX("sex", "Gender", "Personal details", true, false, true, false),
    NATIVE_PLACE("nativePlace", "Hometown", "Personal details", false, false, false, false),
    BIRTHDAY("birthday", "Date of birth", "Personal details", false, false, false, false),
    AGE("age", "Age", "Personal details", false, false, false, false),
    HIGHEST_EDUCATION("highestEducation", "Highest Education", "Personal details", false, false, false, false),
    ADDRESS("address", "Household Address", "Personal details", false, false, false, false),

    JOB_NUMBER("jobNumber", "Employee number", "Hiring details", true, true, false, false),
    ENTRY_STATUS("entryStatus", "Hiring status", "Hiring details", true, true, true, true),
    DEPT_ID("deptId", "Department", "Hiring details", true, false, true, false),
    POST_NAME("postName", "Position title", "Hiring details", true, false, true, false),
    POST_LEVEL("postLevel", "Job Grade", "Hiring details", false, false, false, false),
    LEADER_EMPLOYEE_ID("leaderEmployeeId", "Direct Manager", "Hiring details", true, false, true, false),
    CHANNEL_ID("channelId", "Recruiting Channel", "Hiring details", false, false, false, false),
    TYPE("type", "Employment Type", "Hiring details", true, true, true, true),
    STATUS("status", "Employee status", "Hiring details", true, true, true, true),
    ENTRY_TIME("entryTime", "Hire Date", "Hiring details", true, true, true, true),
    PROBATION("probation", "Probation (months)", "Hiring details", true, true, true, true),
    REGULAR_TIME("regularTime", "Confirmation Date", "Hiring details", false, false, false, false),
    LEAVE_TIME("leaveTime", "Last day", "Hiring details", false, false, false, false),
    COMPANY_AGE_START_TIME("companyAgeStartTime", "Tenure start date", "Hiring details",
            false, false, false, false),
    COMPANY_AGE("companyAge", "Tenure (years)", "Hiring details", false, false, false, false),
    WORK_CITY("workCity", "Work City", "Hiring details", true, false, true, false),
    WORK_ADDRESS("workAddress", "Work Location", "Hiring details", false, false, false, false),
    WORK_DETAIL_ADDRESS("workDetailAddress", "Detailed work address", "Hiring details",
            false, false, false, false),
    CANDIDATE_ID("candidateId", "Recruiting candidate", "Hiring details", false, false, false, false),
    REMARK("remark", "Notes", "Hiring details", true, false, true, false);

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
