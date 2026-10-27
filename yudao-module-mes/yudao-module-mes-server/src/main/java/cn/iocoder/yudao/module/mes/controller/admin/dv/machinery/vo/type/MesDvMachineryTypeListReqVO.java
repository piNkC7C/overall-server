package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Admin - MES device type list request.")
@Data
@Accessors(chain = true)
public class MesDvMachineryTypeListReqVO {

    @Schema(description = "Type name.", example = "CNC machine")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
