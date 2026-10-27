package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES productSOP response.")
@Data
public class MesMdProductSopRespVO {

    @Schema(description = "SOP code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "69")
    private Long itemId;

    @Schema(description = "Sort order.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "OperationID.", example = "100")
    private Long processId;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Step 1")
    private String title;

    @Schema(description = "Detailed description.", example = "ActionNotes.")
    private String description;

    @Schema(description = "ImageAddress.", example = "https://www.example.com/sop.png")
    private String url;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Operation code.", example = "PROC001")
    private String processCode;

    @Schema(description = "Operation name.", example = "Welding operation")
    private String processName;

}
