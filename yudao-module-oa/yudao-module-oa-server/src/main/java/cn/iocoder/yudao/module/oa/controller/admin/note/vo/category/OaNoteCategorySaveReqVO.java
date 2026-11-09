package cn.iocoder.yudao.module.oa.controller.admin.note.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - OA 笔记目录新增/修改 Request VO")
@Data
public class OaNoteCategorySaveReqVO {

    @Schema(description = "目录编号", example = "1024")
    private Long id;

    @Schema(description = "目录名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Work")
    @NotBlank(message = "Directory name is required.")
    @Size(max = 255, message = "Directory name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}
