package cn.iocoder.yudao.module.report.controller.admin.goview.vo.project;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - GoView 项目创建 Request VO")
@Data
public class GoViewProjectCreateReqVO {

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotEmpty(message = "Item name is required.")
    private String name;

}
