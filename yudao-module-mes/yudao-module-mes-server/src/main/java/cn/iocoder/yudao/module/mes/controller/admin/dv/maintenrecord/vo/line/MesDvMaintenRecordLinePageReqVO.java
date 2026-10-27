package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES device maintenance recorddetail page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvMaintenRecordLinePageReqVO extends PageParam {

    @Schema(description = "Maintenance recordID.", example = "1")
    private Long recordId;

}
