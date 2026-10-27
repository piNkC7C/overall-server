package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - CRM contactopportunity request.") // [contact relation opportunity] at relation, cancel relation action
@Data
public class CrmContactBusinessReqVO {

    @Schema(description = "Contact code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20878")
    @NotNull(message="Contact is required.")
    private Long contactId;

    @Schema(description = "Opportunity ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7638")
    @NotEmpty(message="Opportunity is required.")
    private List<Long> businessIds;

}