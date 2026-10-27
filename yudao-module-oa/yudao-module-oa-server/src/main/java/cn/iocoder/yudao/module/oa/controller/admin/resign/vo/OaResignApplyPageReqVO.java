package cn.iocoder.yudao.module.oa.controller.admin.resign.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - offboarding apply please page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaResignApplyPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Offboarding apply please.")
    private String title;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

}
