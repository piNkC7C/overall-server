package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
@Schema(description = "Admin - bargain campaign response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BargainActivityRespVO extends BargainActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long id;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-07-01 23:59:59")
    private LocalDateTime createTime;

}
