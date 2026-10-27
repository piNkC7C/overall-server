package cn.iocoder.yudao.module.oa.controller.admin.note.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - OA Note directory response.")
@Data
public class OaNoteCategoryRespVO {

    @Schema(description = "Directory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Directory name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Work")
    private String name;

    @Schema(description = "Sort", example = "10")
    private Integer sort;

    @Schema(description = "Create time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
