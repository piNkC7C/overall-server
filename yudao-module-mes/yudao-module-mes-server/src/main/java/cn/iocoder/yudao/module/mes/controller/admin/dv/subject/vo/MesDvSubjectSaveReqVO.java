package cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 点检保养项目新增/修改 Request VO")
@Data
public class MesDvSubjectSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "项目编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHK001")
    @NotEmpty(message = "Item code is required.")
    private String code;

    @Schema(description = "项目名称", example = "Injection-machine visual check")
    private String name;

    @Schema(description = "项目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Item type is required.")
    private Integer type;

    @Schema(description = "项目内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Check the injection-molding machine housing for cracks")
    @NotEmpty(message = "Item content is required.")
    private String content;

    @Schema(description = "标准", example = "Appearance is good. No visible damage.")
    private String standard;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
