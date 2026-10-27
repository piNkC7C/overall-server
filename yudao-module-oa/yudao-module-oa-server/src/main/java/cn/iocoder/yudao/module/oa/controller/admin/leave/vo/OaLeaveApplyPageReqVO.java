package cn.iocoder.yudao.module.oa.controller.admin.leave.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - leave request page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaLeaveApplyPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Personal leave request")
    private String title;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

}
