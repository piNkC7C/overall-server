package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * 装修模板 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class DiyTemplateBaseVO {

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Default subject.")
    @NotEmpty(message = "Template name is required.")
    private String name;

    @Schema(description = "Notes.", example = "Default subject.")
    private String remark;

    @Schema(description = "Preview", example = "[https://www.iocoder.cn/1.jpg]")
    private List<String> previewPicUrls;

}
