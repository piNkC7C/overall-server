package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES barcode setting create / edit request.")
@Data
public class MesWmBarcodeConfigSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Barcode format.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Barcode format is required.")
    private Integer format;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "Content format template.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-{BUSINESSCODE}")
    @NotEmpty(message = "Content format template is required.")
    private String contentFormat;

    @Schema(description = "Sample content.", example = "WH-WH001")
    private String contentExample;

    @Schema(description = "Is not Autocreate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not Autocreate is required.")
    private Boolean autoGenerateFlag;

    @Schema(description = "Default print template.", example = "template1")
    private String defaultTemplate;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
