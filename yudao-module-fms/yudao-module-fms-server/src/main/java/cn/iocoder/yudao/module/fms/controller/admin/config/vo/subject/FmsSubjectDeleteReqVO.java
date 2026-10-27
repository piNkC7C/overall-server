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
@Schema(description = "Admin - FMS accountdelete request.")
@Data
public class FmsSubjectDeleteReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Account ID list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Account ID list is required.")
    private List<Long> ids;

}
