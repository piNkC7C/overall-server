package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - CRM contractsetting response.")
@Data
public class CrmContractConfigRespVO {

    @Schema(description = "Early reminder enabled.", example = "true")
    private Boolean notifyEnabled;

    @Schema(description = "Reminder days.", example = "2")
    private Integer notifyDays;

}
