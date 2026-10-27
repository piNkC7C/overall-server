package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "Admin - customerimport request.")
@Data
@Builder
public class CrmCustomerImportReqVO {

    @Schema(description = "Excel file.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Excel file is required.")
    private MultipartFile file;

    @Schema(description = "Is not support update.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not support update is required.")
    private Boolean updateSupport;

    @Schema(description = "Owner person.", example = "1")
    private Long ownerUserId; // 为 null 则客户进入公海

}
