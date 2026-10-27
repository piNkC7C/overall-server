package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * FMS 辅助核算项目状态更新 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS auxiliary accounting item statusupdate request.")
@Data
public class FmsAuxiliaryItemStatusReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
