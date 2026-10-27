package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES miscellaneous inbound order response.")
@Data
public class MesWmMiscReceiptRespVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", example = "MR2026030001")
    private String code;

    @Schema(description = "Inbound order name.", example = "Material return inbound order.")
    private String name;

    @Schema(description = "Miscellaneous type.", example = "1")
    private Integer type;

    @Schema(description = "Source document type.", example = "WORK_ORDER")
    private String sourceDocType;
    @Schema(description = "Source document ID.", example = "1")
    private Long sourceDocId;

    @Schema(description = "Source document code.", example = "WO2026030001")
    private String sourceDocCode;

    @Schema(description = "Inbound date.")
    private LocalDateTime receiptDate;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
