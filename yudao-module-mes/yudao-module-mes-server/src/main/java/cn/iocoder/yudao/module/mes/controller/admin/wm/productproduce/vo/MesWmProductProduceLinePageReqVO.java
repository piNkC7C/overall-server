package cn.iocoder.yudao.module.mes.controller.admin.wm.productproduce.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES production inbound order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmProductProduceLinePageReqVO extends PageParam {

    @Schema(description = "Work-report number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work-report number cannot be empty.")
    private Long feedbackId;

}
