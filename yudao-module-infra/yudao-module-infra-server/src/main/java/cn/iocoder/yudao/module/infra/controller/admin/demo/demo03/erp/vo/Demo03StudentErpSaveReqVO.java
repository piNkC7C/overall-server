package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 学生新增/修改 Request VO")
@Data
public class Demo03StudentErpSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8525")
    private Long id;

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Gender is required.")
    private Integer sex;

    @Schema(description = "出生日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date of birth is required.")
    private LocalDateTime birthday;

    @Schema(description = "简介", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample.")
    @NotEmpty(message = "Bio is required.")
    private String description;

}