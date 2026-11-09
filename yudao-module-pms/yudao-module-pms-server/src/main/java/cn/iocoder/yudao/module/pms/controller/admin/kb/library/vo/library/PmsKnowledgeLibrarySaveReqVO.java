package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.library;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - PMS 知识库新增/修改 Request VO")
@Data
public class PmsKnowledgeLibrarySaveReqVO {

    @Schema(description = "知识库编号", example = "1024")
    private Long id;

    @Schema(description = "知识库名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    @NotBlank(message = "Knowledge base name is required.")
    @Size(max = 50, message = "Knowledge base name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "知识库简介", example = "Build product documentation")
    @Size(max = 300, message = "Knowledge base bio cannot exceed 300 characters.")
    private String description;

    @Schema(description = "是否公开", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Knowledge base visibility is required.")
    private Boolean openStatus;

    @Schema(description = "知识库封面")
    @Size(max = 255, message = "Knowledge base cover Address cannot exceed 255 characters.")
    private String coverUrl;

    @Schema(description = "创建时的初始管理员用户编号列表", example = "[1, 2]")
    private List<Long> adminUserIds;

    @Schema(description = "创建时的初始普通成员用户编号列表", example = "[3, 4]")
    private List<Long> memberUserIds;

    @Schema(description = "模板编号，仅创建时有效", example = "1")
    @Positive(message = "Template ID must be greater than 0.")
    private Long templateId;

}
