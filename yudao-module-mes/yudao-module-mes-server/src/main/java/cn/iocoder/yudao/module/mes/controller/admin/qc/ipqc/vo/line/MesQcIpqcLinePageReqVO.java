package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES in-process inspection line page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcIpqcLinePageReqVO extends PageParam {

    @Schema(description = "In-process inspection ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "In-process inspection ID cannot be empty.")
    private Long ipqcId;

}
