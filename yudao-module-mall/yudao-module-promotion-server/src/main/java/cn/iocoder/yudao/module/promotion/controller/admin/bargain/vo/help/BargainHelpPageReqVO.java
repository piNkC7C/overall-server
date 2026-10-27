package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.help;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - bargain assist page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BargainHelpPageReqVO extends PageParam {

    @Schema(description = "Bargain record code.", example = "1800")
    private Long recordId;

}
