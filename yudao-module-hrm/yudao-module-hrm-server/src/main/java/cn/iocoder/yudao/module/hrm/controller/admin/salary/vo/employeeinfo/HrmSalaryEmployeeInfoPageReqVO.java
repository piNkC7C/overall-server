package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "Admin - HRM employeepayroll info page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalaryEmployeeInfoPageReqVO extends PageParam {

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Employee code list.", example = "[1024, 1025]")
    private List<Long> employeeIds;

    @Schema(description = "Adjust type.", example = "1")
    private Integer changeType;

    @Schema(description = "Employee Name or Employee No.", example = "John.")
    private String search;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Post name.", example = "Java engineer.")
    private String postName;

    @Schema(description = "Employee status.", example = "1")
    private Integer status;

    @Schema(description = "Onboarding status.", example = "1")
    private Integer entryStatus;

    @Schema(description = "Employee status tab.", example = "1")
    private Integer statusCategory;

}
