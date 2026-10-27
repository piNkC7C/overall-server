package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo.content;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES production operation content page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProProcessContentPageReqVO extends PageParam {

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Operation code is required.")
    private Long processId;

}
