package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 安灯呼叫配置新增/修改 Request VO")
@Data
public class MesProAndonConfigSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "呼叫原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Equipment fault")
    @NotEmpty(message = "Call Reason is required.")
    private String reason;

    @Schema(description = "级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Level is required.")
    private Integer level;

    @Schema(description = "处置人角色编号", example = "10")
    private Long handlerRoleId;

    @Schema(description = "处置人编号", example = "100")
    private Long handlerUserId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
