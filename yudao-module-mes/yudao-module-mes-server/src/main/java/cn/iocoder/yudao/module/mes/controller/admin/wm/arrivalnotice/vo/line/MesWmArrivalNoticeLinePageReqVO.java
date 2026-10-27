package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES receiving notification order line page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmArrivalNoticeLinePageReqVO extends PageParam {

    @Schema(description = "Receiving notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving notification order code is required.")
    private Long noticeId;

}
