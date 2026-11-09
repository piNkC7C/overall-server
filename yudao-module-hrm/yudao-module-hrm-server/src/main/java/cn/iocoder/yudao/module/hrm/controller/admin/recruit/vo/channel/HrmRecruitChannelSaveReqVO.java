package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.channel;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 招聘渠道新增/修改 Request VO")
@Data
public class HrmRecruitChannelSaveReqVO {

    @Schema(description = "招聘渠道编号", example = "1024")
    private Long id;

    @Schema(description = "渠道名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "LinkedIn")
    @NotBlank(message = "Channel name is required.")
    @Size(max = 255, message = "Channel name cannot exceed 255 characters.")
    @DiffLogField(name = "渠道名称")
    private String name;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    @Min(value = 0, message = "Sort order cannot be less than 0.")
    @DiffLogField(name = "显示顺序")
    private Integer sort;

    @Schema(description = "备注", example = "Common channel")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "备注")
    private String remark;

}
