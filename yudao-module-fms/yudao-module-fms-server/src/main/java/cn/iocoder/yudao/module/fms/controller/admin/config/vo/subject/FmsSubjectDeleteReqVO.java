package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * FMS 科目删除 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - FMS 科目删除 Request VO")
@Data
public class FmsSubjectDeleteReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "科目编号数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Account ID list is required.")
    private List<Long> ids;

}
