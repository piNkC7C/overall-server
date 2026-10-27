package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES shipping notification order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmSalesNoticeLinePageReqVO extends PageParam {

    @Schema(description = "Shipping notification order code.", example = "1")
    private Long noticeId;

}
