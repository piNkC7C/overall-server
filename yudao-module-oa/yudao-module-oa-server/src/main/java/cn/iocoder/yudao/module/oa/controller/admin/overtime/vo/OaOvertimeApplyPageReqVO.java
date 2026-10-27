package cn.iocoder.yudao.module.oa.controller.admin.overtime.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Overtime request page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaOvertimeApplyPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Go-live overtime request")
    private String title;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

}
