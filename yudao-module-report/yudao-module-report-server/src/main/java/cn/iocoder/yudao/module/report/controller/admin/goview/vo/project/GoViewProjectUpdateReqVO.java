package cn.iocoder.yudao.module.report.controller.admin.goview.vo.project;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import jakarta.validation.constraints.*;

@Schema(description = "Admin - GoView item update request.")
@Data
public class GoViewProjectUpdateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18993")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "Published.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = CommonStatusEnum.class, message = "Published must be {value}.")
    private Integer status;

    @Schema(description = "Report content.") // JSON
    private String content;

    @Schema(description = "Preview image URL.", example = "https://www.iocoder.cn")
    private String picUrl;

    @Schema(description = "Item notes.", example = "Example.")
    private String remark;

}
