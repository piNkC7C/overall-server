package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsSubjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * FMS 科目列表 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS account list request.")
@Data
public class FmsSubjectListReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Account type.", example = "1")
    @InEnum(FmsSubjectTypeEnum.class)
    private Integer type;

}
