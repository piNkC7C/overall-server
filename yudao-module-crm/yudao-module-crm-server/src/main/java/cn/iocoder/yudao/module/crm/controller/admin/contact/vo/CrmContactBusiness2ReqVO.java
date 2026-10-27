package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - CRM contactopportunity request.") // [opportunity relation contact] at relation, cancel relation action
@Data
public class CrmContactBusiness2ReqVO {

    @Schema(description = "Opportunity code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7638")
    @NotNull(message="Opportunity is required.")
    private Long businessId;

    @Schema(description = "Contact ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20878")
    @NotEmpty(message="ContactArray is required.")
    private List<Long> contactIds;

}