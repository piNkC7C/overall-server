package cn.iocoder.yudao.module.report.controller.admin.goview.vo.project;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - GoView 项目更新 Request VO")
@Data
public class GoViewProjectUpdateReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18993")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "发布状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = CommonStatusEnum.class, message = "Published must be {value}.")
    private Integer status;

    @Schema(description = "报表内容") // JSON
    private String content;

    @Schema(description = "预览图片 URL", example = "https://www.iocoder.cn")
    private String picUrl;

    @Schema(description = "项目备注", example = "Example.")
    private String remark;

}
