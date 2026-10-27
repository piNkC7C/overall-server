package cn.iocoder.yudao.module.mes.controller.admin.qc.indicatorresult.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - MES inspection result create or update request.")
@Data
public class MesQcIndicatorResultSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Sample ID.", example = "SPL-001")
    private String code;

    @Schema(description = "Relation quality inspection order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Relation quality inspection order ID is required.")
    private Long qcId;

    @Schema(description = "Quality inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quality inspection type is required.")
    @InEnum(MesQcTypeEnum.class)
    private Integer qcType;

    @Schema(description = "Item SN.", example = "SN-001")
    private String sn;

    @Schema(description = "Notes.", example = "No.")
    private String remark;

    @Schema(description = "Inspection resultdetail list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Inspection resultdetail list is required.")
    private List<Item> items;

    @Schema(description = "Inspection resultdetail item.")
    @Data
    public static class Item {

        @Schema(description = "ID. Pass an existing line ID when updating.", example = "1024")
        private Long id;

        @Schema(description = "Inspect metric ID.", example = "1")
        private Long indicatorId;

        @Schema(description = "Inspection value (stored as text).", example = "3.14")
        private String value;

        @Schema(description = "Notes.", example = "No.")
        private String remark;

    }

}
