package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 条码配置新增/修改 Request VO")
@Data
public class MesWmBarcodeConfigSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "条码格式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Barcode format is required.")
    private Integer format;

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "内容格式模板", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-{BUSINESSCODE}")
    @NotEmpty(message = "Content format template is required.")
    private String contentFormat;

    @Schema(description = "内容样例", example = "WH-WH001")
    private String contentExample;

    @Schema(description = "是否自动生成", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not Autocreate is required.")
    private Boolean autoGenerateFlag;

    @Schema(description = "默认打印模板", example = "template1")
    private String defaultTemplate;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
