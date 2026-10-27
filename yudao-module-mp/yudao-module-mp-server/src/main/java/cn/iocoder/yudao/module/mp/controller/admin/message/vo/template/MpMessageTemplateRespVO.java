package cn.iocoder.yudao.module.mp.controller.admin.message.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - Official Accounttemplatemessage response.")
@Data
public class MpMessageTemplateRespVO {

    @Schema(description = "Template primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7019")
    private Long id;

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountId;

    @Schema(description = "appId", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx1234567890abcdef")
    private String appId;

    @Schema(description = "Official AccounttemplateID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IjkGxO9M_mC9pE5Yl7QYJk1h0Dj2N4lC3oOp6rRsT8u")
    private String templateId;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order status reminder")
    private String title;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Template sample.")
    private String example;

    @Schema(description = "Template industry primary industry.", example = "E-commerce")
    private String primaryIndustry;

    @Schema(description = "Template industry secondary industry.", example = "Product after-sales.")
    private String deputyIndustry;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}