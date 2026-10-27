package cn.iocoder.yudao.module.oa.controller.admin.regular.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - confirmation apply please page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaRegularApplyPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Probation confirmation request")
    private String title;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

}
