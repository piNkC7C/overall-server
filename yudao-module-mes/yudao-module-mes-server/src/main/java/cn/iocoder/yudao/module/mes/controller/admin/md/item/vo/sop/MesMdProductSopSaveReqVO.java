package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 产品SOP新增/修改 Request VO")
@Data
public class MesMdProductSopSaveReqVO {

    @Schema(description = "SOP编号", example = "1024")
    private Long id;

    @Schema(description = "物料产品ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "69")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "排列顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort order cannot be empty.")
    private Integer sort;

    @Schema(description = "工序ID", example = "100")
    private Long processId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Step 1")
    @NotEmpty(message = "Title is required.")
    private String title;

    @Schema(description = "详细描述", example = "ActionNotes.")
    private String description;

    @Schema(description = "图片地址", example = "https://www.example.com/sop.png")
    private String url;

    @Schema(description = "备注", example = "Notes info.")
    private String remark;

}
