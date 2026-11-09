package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "管理后台 - 客户导入 Request VO")
@Data
@Builder
public class CrmCustomerImportReqVO {

    @Schema(description = "Excel 文件", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Excel file is required.")
    private MultipartFile file;

    @Schema(description = "是否支持更新", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not support update is required.")
    private Boolean updateSupport;

    @Schema(description = "负责人", example = "1")
    private Long ownerUserId; // 为 null 则客户进入公海

}
