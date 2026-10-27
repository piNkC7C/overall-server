package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES productSOP create / edit request.")
@Data
public class MesMdProductSopSaveReqVO {

    @Schema(description = "SOP code.", example = "1024")
    private Long id;

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "69")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "Sort order.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort order cannot be empty.")
    private Integer sort;

    @Schema(description = "OperationID.", example = "100")
    private Long processId;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Step 1")
    @NotEmpty(message = "Title is required.")
    private String title;

    @Schema(description = "Detailed description.", example = "ActionNotes.")
    private String description;

    @Schema(description = "ImageAddress.", example = "https://www.example.com/sop.png")
    private String url;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}
