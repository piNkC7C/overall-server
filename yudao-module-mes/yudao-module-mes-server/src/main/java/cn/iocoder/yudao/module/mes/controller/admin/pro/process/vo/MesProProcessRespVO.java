package cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 生产工序 Response VO")
@Data
public class MesProProcessRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "工序编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PROCESS001")
    private String code;

    @Schema(description = "工序名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cutting operation")
    private String name;

    @Schema(description = "工艺要求", example = "Cut to the drawing size")
    private String attention;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "备注", example = "Sheet-metal cutting")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
