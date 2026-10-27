package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES production material return order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmReturnIssueLinePageReqVO extends PageParam {

    @Schema(description = "Material return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order code is required.")
    private Long issueId;

}
