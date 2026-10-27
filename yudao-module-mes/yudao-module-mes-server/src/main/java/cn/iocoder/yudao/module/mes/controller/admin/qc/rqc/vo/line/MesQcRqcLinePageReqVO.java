package cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES return inspection line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcRqcLinePageReqVO extends PageParam {

    @Schema(description = "Return inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Return inspection ID is required.")
    private Long rqcId;

}
