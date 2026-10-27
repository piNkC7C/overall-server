package cn.iocoder.yudao.module.promotion.controller.admin.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - Banner response.")
@Data
@ToString(callSuper = true)
public class BannerRespVO  extends BannerBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-07-01 23:59:59")
    private LocalDateTime createTime;

}
