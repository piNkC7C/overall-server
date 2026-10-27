package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.group;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - HRM attendance group page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmAttendanceGroupPageReqVO extends PageParam {

    @Schema(description = "Attendance group name.", example = "Default attendance group.")
    private String name;

    @Schema(description = "Is not default attendance group.", example = "true")
    private Boolean defaultStatus;

}
