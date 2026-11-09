package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.label;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 工作项标签新增/修改 Request VO")
@Data
public class PmsWorkItemLabelSaveReqVO {

    @Schema(description = "标签编号", example = "1024")
    private Long id;

    @Schema(description = "标签名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Urgent")
    @NotBlank(message = "Tag name is required.")
    @Size(max = 50, message = "Tag name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "标签颜色", requiredMode = Schema.RequiredMode.REQUIRED, example = "#409EFF")
    @NotBlank(message = "Tag color is required.")
    @Size(max = 20, message = "Tag color cannot exceed 20 characters.")
    private String color;

}
