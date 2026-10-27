package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 装修页面 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class DiyPageBaseVO {

    @Schema(description = "Decorate template ID.", example = "26179")
    private Long templateId;

    @Schema(description = "Page Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotNull(message = "Page Name is required.")
    private String name;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Preview")
    private List<String> previewPicUrls;

}
