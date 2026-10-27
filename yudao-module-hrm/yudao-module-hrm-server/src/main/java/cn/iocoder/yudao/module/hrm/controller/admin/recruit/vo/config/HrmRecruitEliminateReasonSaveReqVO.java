package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.config;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - HRM RecruitingRejection Reason save request.")
@Data
public class HrmRecruitEliminateReasonSaveReqVO {

    @Schema(description = "Rejection Reason list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Rejection Reason is required.")
    @DiffLogField(name = "Rejection Reason")
    private List<@NotBlank(message = "Rejection Reason is required.") String> reasons;

}
