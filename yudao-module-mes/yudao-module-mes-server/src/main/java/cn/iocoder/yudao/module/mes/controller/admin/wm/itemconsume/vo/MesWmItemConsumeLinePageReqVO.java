package cn.iocoder.yudao.module.mes.controller.admin.wm.itemconsume.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES material consumption line page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmItemConsumeLinePageReqVO extends PageParam {

    @Schema(description = "Work report record code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Work report record code is required.")
    private Long feedbackId;

}
