package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS journal entryimport result response.")
@Data
public class FmsVoucherImportRespVO {

    @Schema(description = "Total entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer totalRowCount;

    @Schema(description = "Succeeded entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer successRowCount;

    @Schema(description = "Failed entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer failureRowCount;

    @Schema(description = "Total journal entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer totalVoucherCount;

    @Schema(description = "Succeeded journal entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer successVoucherCount;

    @Schema(description = "Failed journal entries.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer failureVoucherCount;

    @Schema(description = "Error data fileAddress.")
    private String errorFileUrl;

    /**
     * 错误数据数组
     *
     * 仅用于生成错误数据文件，不直接返回前端
     */
    @JsonIgnore
    private List<FmsVoucherImportExcelVO> errorRows;

}
