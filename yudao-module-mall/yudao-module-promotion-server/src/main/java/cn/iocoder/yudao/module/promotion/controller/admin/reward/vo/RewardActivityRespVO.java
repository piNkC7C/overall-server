package cn.iocoder.yudao.module.promotion.controller.admin.reward.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - spend-and-save campaign response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RewardActivityRespVO extends RewardActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
