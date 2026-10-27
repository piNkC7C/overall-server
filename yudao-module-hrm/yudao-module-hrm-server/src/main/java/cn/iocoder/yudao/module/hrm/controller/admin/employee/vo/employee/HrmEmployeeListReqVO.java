package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeEntryStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusTabEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeSurveyTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTodoTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM employee profile list request.")
@Data
public class HrmEmployeeListReqVO {

    @Schema(description = "Employee code list.", example = "1,2")
    private List<Long> ids;

    @Schema(hidden = true)
    private List<Long> excludeIds;

    @Schema(description = "Employee Name or Employee No., fuzzy match.", example = "John.")
    private String search;

    @Schema(description = "Employee Name, fuzzy match.", example = "Zhang")
    private String name;

    @Schema(description = "Employee No., fuzzy match.", example = "HRM")
    private String jobNumber;

    @Schema(description = "Phone number, fuzzy match.", example = "156")
    private String mobile;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department ID list.", example = "100,101")
    private List<Long> deptIds;

    @Schema(description = "Direct Manageremployee code.", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Hire DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] entryTime;

    @Schema(description = "Job Title name, fuzzy match.", example = "Java")
    private String postName;

    @Schema(description = "Confirmation DateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] regularTime;

    @Schema(description = "Work Location, fuzzy match.", example = "Downtown")
    private String workAddress;

    @Schema(description = "Recruiting Channel code.", example = "10")
    private Long channelId;

    @Schema(description = "Employment Type", example = "1")
    @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
    private Integer type;

    @Schema(description = "Onboarding status.", example = "1")
    @InEnum(value = HrmEmployeeEntryStatusEnum.class, message = "Onboarding status must be {value}.")
    private Integer entryStatus;

    @Schema(description = "Employee status.", example = "1")
    @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
    private Integer status;

    @Schema(description = "Employee statuscategory.", example = "12")
    @InEnum(value = HrmEmployeeStatusTabEnum.class, message = "Employee statuscategory must be {value}.")
    private Integer statusCategory;

    @Schema(description = "Home workforce filter type.", example = "1")
    @InEnum(value = HrmEmployeeSurveyTypeEnum.class, message = "Home workforce filter type must be {value}.")
    private Integer surveyType;

    @Schema(description = "Home to-do filter type.", example = "5")
    @InEnum(value = HrmEmployeeTodoTypeEnum.class, message = "Home to-do filter type must be {value}.")
    private Integer todoType;

    @Schema(hidden = true)
    private LocalDateTime[] activeTime;

}
