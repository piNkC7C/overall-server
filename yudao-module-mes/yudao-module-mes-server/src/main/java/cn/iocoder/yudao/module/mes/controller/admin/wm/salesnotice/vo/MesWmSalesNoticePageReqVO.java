package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES shipping notification order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmSalesNoticePageReqVO extends PageParam {

    @Schema(description = "Notification order code.", example = "SN202603010001")
    private String code;

    @Schema(description = "Notification order name.", example = "Test shipment notice")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer code.", example = "1")
    private Long clientId;

    @Schema(description = "Status.", example = "3")
    private Integer status;

}
