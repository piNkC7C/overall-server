package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES repair work order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvRepairLinePageReqVO extends PageParam {

    @Schema(description = "Repair work order code.", example = "1")
    private Long repairId;

}
