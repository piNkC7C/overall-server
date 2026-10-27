package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - MES 销售退货单新增/修改 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return create / edit request.")
@Data
public class MesWmReturnSalesSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RS202603010001")
    @NotBlank(message = "Return order code is required.")
    private String code;

    @Schema(description = "Return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sales return.")
    @NotBlank(message = "Return order name is required.")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer ID is required.")
    private Long clientId;

    @Schema(description = "Return Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Return Date is required.")
    private LocalDateTime returnDate;

    @Schema(description = "Return reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Quality issue")
    @NotBlank(message = "Return reason is required.")
    private String returnReason;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
