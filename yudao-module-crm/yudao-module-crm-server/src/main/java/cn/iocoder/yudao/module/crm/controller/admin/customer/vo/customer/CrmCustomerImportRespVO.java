package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - customerimport response.")
@Data
@Builder
public class CrmCustomerImportRespVO {

    @Schema(description = "Created customer names.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createCustomerNames;

    @Schema(description = "Updated customer names.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateCustomerNames;

    @Schema(description = "Failed customer import map. Key is customer name. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureCustomerNames;

}
