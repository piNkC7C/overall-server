package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.poolconfig;

import cn.hutool.core.util.BooleanUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

@Schema(description = "Create or update customer pool setting request VO.")
@Data
public class CrmCustomerPoolConfigSaveReqVO {

    @Schema(description = "Customer pool enabled.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @DiffLogField(name = "Enable Customer Pool")
    @NotNull(message = "Customer pool enabled cannot be empty.")
    private Boolean enabled;

    @Schema(description = "Days in pool after no follow-up.", example = "2")
    @DiffLogField(name = "Days Without Follow-up Before Pool")
    private Integer contactExpireDays;

    @Schema(description = "Days in pool after no win.", example = "2")
    @DiffLogField(name = "Days Without Deal Before Pool")
    private Integer dealExpireDays;

    @Schema(description = "Early reminder enabled.", example = "true")
    @DiffLogField(name = "Enable Advance Reminder")
    private Boolean notifyEnabled;

    @Schema(description = "Reminder days.", example = "2")
    @DiffLogField(name = "Advance Reminder Days")
    private Integer notifyDays;

    @AssertTrue(message = "Days in pool after no win cannot be empty.")
    @JsonIgnore
    public boolean isDealExpireDaysValid() {
        if (!BooleanUtil.isTrue(getEnabled())) {
            return true;
        }
        return Objects.nonNull(getDealExpireDays());
    }

    @AssertTrue(message = "Days in pool after no follow-up cannot be empty.")
    @JsonIgnore
    public boolean isContactExpireDaysValid() {
        if (!BooleanUtil.isTrue(getEnabled())) {
            return true;
        }
        return Objects.nonNull(getContactExpireDays());
    }

    @AssertTrue(message = "Reminder days cannot be empty.")
    @JsonIgnore
    public boolean isNotifyDaysValid() {
        if (!BooleanUtil.isTrue(getNotifyEnabled())) {
            return true;
        }
        return Objects.nonNull(getNotifyDays());
    }

}
