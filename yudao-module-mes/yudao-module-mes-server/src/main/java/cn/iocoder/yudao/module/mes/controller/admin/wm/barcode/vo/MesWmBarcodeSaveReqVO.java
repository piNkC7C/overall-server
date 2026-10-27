package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "MES barcode list create / update request VO.")
@Data
public class MesWmBarcodeSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Barcode setting code.", example = "1")
    private Long configId;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "Barcode content.", example = "WH-WH001")
    private String content;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Business code is required.")
    private Long bizId;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH001")
    @NotEmpty(message = "Business code is required.")
    private String bizCode;

    @Schema(description = "Business name.", example = "Raw Materials.")
    private String bizName;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
