package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "HRM performance archive page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformanceArchivePageReqVO extends PageParam {

    @Schema(description = "Performance reviewplan code.", example = "1024")
    private Long planId;

    @Schema(description = "Employee code.", example = "2048")
    private Long employeeId;

    @Schema(description = "Employee code list.", example = "[2048, 2049]")
    private List<Long> employeeIds;

}
