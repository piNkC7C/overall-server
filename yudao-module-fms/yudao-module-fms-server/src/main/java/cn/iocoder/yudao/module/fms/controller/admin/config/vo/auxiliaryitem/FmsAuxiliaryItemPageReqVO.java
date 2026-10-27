package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * FMS 辅助核算项目分页 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS auxiliary accounting item page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class FmsAuxiliaryItemPageReqVO extends PageParam {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Auxiliary category ID is required.")
    private Long auxiliaryTypeId;

    @Schema(description = "Keyword, match code or name.", example = "Test")
    private String search;

}
