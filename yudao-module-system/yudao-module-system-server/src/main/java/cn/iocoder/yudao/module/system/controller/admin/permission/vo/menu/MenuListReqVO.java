package cn.iocoder.yudao.module.system.controller.admin.permission.vo.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - menu list request.")
@Data
public class MenuListReqVO {

    @Schema(description = "Menu name, fuzzy match.", example = "Overall.")
    private String name;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

}
