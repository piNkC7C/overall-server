package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES subcontract issue order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmOutsourceIssueLinePageReqVO extends PageParam {

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issue materials order ID is required.")
    private Long issueId;

}
