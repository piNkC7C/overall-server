package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.post;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.recruit.post.HrmRecruitPostStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM RecruitingJob Title status edit request.")
@Data
public class HrmRecruitPostStatusReqVO {

    @Schema(description = "RecruitingJob Title code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "RecruitingJob Title code is required.")
    private Long id;

    @Schema(description = "Job Title status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Job Title status is required.")
    @InEnum(value = HrmRecruitPostStatusEnum.class, message = "Job Title status must be {value}.")
    private Integer status;

    @Schema(description = "Stop reason.", example = "Job on hold")
    @Size(max = 255, message = "Stop reason cannot exceed 255 characters.")
    private String stopReason;

    @AssertTrue(message = "Stop reason when closing the job cannot be empty.")
    @JsonIgnore
    public boolean isStopReasonValid() {
        return ObjUtil.notEqual(HrmRecruitPostStatusEnum.STOPPED.getStatus(), status)
                || StrUtil.isNotBlank(stopReason);
    }

}
