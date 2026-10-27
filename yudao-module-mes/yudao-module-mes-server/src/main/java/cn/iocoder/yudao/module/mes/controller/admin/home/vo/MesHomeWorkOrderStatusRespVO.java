package cn.iocoder.yudao.module.mes.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "MES home work order status distribution response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MesHomeWorkOrderStatusRespVO {

    @Schema(description = "StatusValue.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Draft.")
    private String statusName;

    @Schema(description = "Work order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long count;

}
