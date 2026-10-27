package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.config;

import cn.hutool.core.util.BooleanUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

import java.util.Objects;

@Schema(description = "Admin - CRM contractsetting request.")
@Data
public class CrmContractConfigSaveReqVO {

    @Schema(description = "Early reminder enabled.", example = "true")
    @DiffLogField(name = "Enable Advance Reminder")
    private Boolean notifyEnabled;

    @Schema(description = "Reminder days.", example = "2")
    @DiffLogField(name = "Advance Reminder Days")
    private Integer notifyDays;

    @AssertTrue(message = "Reminder days cannot be empty.")
    @JsonIgnore
    public boolean isNotifyDaysValid() {
        if (!BooleanUtil.isTrue(getNotifyEnabled())) {
            return true;
        }
        return Objects.nonNull(getNotifyDays());
    }

}
