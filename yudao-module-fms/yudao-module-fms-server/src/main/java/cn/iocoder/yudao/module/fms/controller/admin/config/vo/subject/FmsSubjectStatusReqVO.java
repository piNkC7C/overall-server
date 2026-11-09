package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * FMS 科目状态更新 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - FMS 科目状态更新 Request VO")
@Data
public class FmsSubjectStatusReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "科目编号数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Account ID list is required.")
    private List<Long> ids;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
