package cn.iocoder.yudao.module.promotion.controller.admin.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xia
 */
@Schema(description = "Admin - Bannerupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BannerUpdateReqVO extends BannerBaseVO {

    @Schema(description = "Banner code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Banner code is required.")
    private Long id;

}
