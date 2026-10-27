package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES device inspection recorddetail page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvCheckRecordLinePageReqVO extends PageParam {

    @Schema(description = "Inspection record code.", example = "1")
    private Long recordId;

}
