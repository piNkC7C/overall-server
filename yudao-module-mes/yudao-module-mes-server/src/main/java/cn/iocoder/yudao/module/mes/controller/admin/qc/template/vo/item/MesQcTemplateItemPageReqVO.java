package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES quality inspection plan -product relation page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcTemplateItemPageReqVO extends PageParam {

    @Schema(description = "Quality inspection plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quality inspection plan ID is required.")
    private Long templateId;

}
