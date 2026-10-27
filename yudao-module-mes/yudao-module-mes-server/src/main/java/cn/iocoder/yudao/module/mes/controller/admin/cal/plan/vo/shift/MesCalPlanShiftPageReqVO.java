package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES plan shift page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesCalPlanShiftPageReqVO extends PageParam {

    @Schema(description = "Schedule plan code.", example = "1")
    private Long planId;

    @Schema(description = "Shift name.", example = "Day shift")
    private String name;

}
