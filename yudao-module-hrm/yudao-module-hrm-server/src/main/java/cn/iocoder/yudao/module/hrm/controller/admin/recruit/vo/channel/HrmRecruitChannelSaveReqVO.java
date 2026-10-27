package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.channel;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM Recruiting Channel create / edit request.")
@Data
public class HrmRecruitChannelSaveReqVO {

    @Schema(description = "Recruiting Channel code.", example = "1024")
    private Long id;

    @Schema(description = "Channel name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "LinkedIn")
    @NotBlank(message = "Channel name is required.")
    @Size(max = 255, message = "Channel name cannot exceed 255 characters.")
    @DiffLogField(name = "Channel name.")
    private String name;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    @Min(value = 0, message = "Sort order cannot be less than 0.")
    @DiffLogField(name = "Sort")
    private Integer sort;

    @Schema(description = "Notes.", example = "Common channel")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

}
