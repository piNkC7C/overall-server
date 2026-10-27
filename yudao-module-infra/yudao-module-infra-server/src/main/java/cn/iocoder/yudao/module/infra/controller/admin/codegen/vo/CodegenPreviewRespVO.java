package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Codegen preview response VO.")
@Data
public class CodegenPreviewRespVO {

    @Schema(description = "File path", requiredMode = Schema.RequiredMode.REQUIRED, example = "java/cn/iocoder/yudao/adminserver/modules/system/controller/test/SysTestDemoController.java")
    private String filePath;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hello World")
    private String code;

}
