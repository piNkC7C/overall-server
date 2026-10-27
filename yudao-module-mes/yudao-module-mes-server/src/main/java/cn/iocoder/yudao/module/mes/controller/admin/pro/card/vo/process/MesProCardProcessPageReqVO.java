package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo.process;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES routing card operationrecord page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProCardProcessPageReqVO extends PageParam {

    @Schema(description = "Routing card code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Routing card code is required.")
    private Long cardId;

    @Schema(description = "Operation code.", example = "200")
    private Long processId;

    @Schema(description = "WorkstationID.", example = "300")
    private Long workstationId;

    @Schema(description = "Action person code.", example = "400")
    private Long userId;

}
