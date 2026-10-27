package cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - department list request.")
@Data
public class DeptListReqVO {

    @Schema(description = "Department name, fuzzy match.", example = "Overall.")
    private String name;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

}
