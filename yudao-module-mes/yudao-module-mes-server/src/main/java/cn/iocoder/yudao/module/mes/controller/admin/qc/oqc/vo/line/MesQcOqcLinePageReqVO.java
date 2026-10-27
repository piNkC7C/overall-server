package cn.iocoder.yudao.module.mes.controller.admin.qc.oqc.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES outgoing inspection line page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcOqcLinePageReqVO extends PageParam {

    @Schema(description = "Outgoing inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Outgoing inspection ID cannot be empty.")
    private Long oqcId;

}
