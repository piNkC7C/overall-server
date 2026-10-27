package cn.iocoder.yudao.module.pms.controller.admin.pm.iteration.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.iteration.PmsIterationStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - PMS item sprint page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsIterationPageReqVO extends PageParam {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Sprint name.", example = "Phase 1")
    private String name;

    @Schema(description = "Sprint status.", example = "1")
    @InEnum(PmsIterationStatusEnum.class)
    private Integer status;

}
