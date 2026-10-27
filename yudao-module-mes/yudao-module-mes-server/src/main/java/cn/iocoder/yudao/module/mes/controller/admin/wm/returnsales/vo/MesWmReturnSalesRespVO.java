package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return response.")
@Data
public class MesWmReturnSalesRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RS202603010001")
    private String code;

    @Schema(description = "Return order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sales return.")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long clientId;

    @Schema(description = "Customer code.", example = "C001")
    private String clientCode;

    @Schema(description = "Customer name.", example = "XXcustomer.")
    private String clientName;

    @Schema(description = "Customer short name.", example = "XX")
    private String clientNickname;

    @Schema(description = "Return Date.")
    private LocalDateTime returnDate;

    @Schema(description = "Return reason.", example = "Quality issue")
    private String returnReason;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
