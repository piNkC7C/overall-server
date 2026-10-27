package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.candidate;

import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeSaveReqVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM candidate convert to employee request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmRecruitCandidateEntryReqVO extends HrmEmployeeSaveReqVO {

    @AssertTrue(message = "Candidate code is required.")
    @JsonIgnore
    public boolean isCandidateIdValid() {
        return getCandidateId() != null;
    }

}
