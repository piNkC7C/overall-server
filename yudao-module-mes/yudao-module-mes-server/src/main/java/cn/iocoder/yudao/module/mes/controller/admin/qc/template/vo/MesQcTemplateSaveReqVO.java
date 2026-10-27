package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - MES quality inspection plan create / edit request.")
@Data
public class MesQcTemplateSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "QCT001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finished-goods outgoing inspection plan")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "Inspection Type (1-IQC 2-IPQC 3-OQC 4-RQC, dictionary mes_qc_type).", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    @NotNull(message = "Inspection Type is required.")
    @Size(min = 1, message = "Select at least one inspection type.")
    private List<Integer> types;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
