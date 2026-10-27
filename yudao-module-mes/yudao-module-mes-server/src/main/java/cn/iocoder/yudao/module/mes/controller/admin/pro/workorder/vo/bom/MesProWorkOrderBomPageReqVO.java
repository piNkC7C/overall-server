package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo.bom;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES production work order BOM page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProWorkOrderBomPageReqVO extends PageParam {

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Production work order code is required.")
    private Long workOrderId;

}
