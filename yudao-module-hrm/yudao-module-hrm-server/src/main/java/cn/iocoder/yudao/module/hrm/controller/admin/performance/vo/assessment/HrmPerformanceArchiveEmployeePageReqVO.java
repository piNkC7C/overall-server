package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM employeeperformance review profile page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformanceArchiveEmployeePageReqVO extends PageParam {

    @Schema(description = "Employee Name or Employee No., fuzzy match.", example = "John.")
    private String search;

}
