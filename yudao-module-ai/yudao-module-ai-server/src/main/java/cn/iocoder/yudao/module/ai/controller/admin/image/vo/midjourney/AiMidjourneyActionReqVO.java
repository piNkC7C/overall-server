package cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - AI 绘图操作（Midjourney） Request VO")
@Data
public class AiMidjourneyActionReqVO {

    @Schema(description = "图片编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Image code is required.")
    private Long id;

    @Schema(description = "操作按钮编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "MJ::JOB::variation::4::06aa3e66-0e97-49cc-8201-e0295d883de4")
    @NotEmpty(message = "Action code is required.")
    private String customId;

}
