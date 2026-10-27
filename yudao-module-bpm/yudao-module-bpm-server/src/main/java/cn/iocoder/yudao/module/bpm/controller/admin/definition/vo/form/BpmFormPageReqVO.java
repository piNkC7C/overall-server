package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - dynamic form page request.")
@Data
public class BpmFormPageReqVO extends PageParam {

    @Schema(description = "Form name.", example = "Overall.")
    private String name;

}
