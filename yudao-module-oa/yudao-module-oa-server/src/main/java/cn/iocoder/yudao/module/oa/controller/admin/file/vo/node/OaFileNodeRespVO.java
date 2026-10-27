package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Cloud-drive file response VO.")
@Data
public class OaFileNodeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Parent directory code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

    @Schema(description = "Node type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer type;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "office-supply-count.pdf")
    private String name;

    @Schema(description = "Temporary file URL. Returned in detail only when download is allowed.", example = "https://example.com/file.pdf")
    private String url;

    @Schema(description = "Extension.", example = "pdf")
    private String extension;

    @Schema(description = "Filecategory.", example = "1")
    private Integer category;

    @Schema(description = "Size in bytes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long size;

    @Schema(description = "Node status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Creator.", example = "1024")
    private String creator;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime updateTime;

    @Schema(description = "Current user permission level.", example = "1")
    private Integer level;

    @Schema(description = "Is not Favorite.", example = "false")
    private Boolean favorite;

}
