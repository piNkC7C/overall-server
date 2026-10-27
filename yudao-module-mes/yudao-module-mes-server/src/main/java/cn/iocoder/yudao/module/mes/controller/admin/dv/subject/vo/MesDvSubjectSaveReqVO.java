package cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES inspection and maintenance item create / edit request.")
@Data
public class MesDvSubjectSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHK001")
    @NotEmpty(message = "Item code is required.")
    private String code;

    @Schema(description = "Item name.", example = "Injection-machine visual check")
    private String name;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Item type is required.")
    private Integer type;

    @Schema(description = "Item content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Check the injection-molding machine housing for cracks")
    @NotEmpty(message = "Item content is required.")
    private String content;

    @Schema(description = "Standard.", example = "Appearance is good. No visible damage.")
    private String standard;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
