package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.process;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - workflow definition page request.")
@Data
public class BpmProcessDefinitionPageReqVO extends PageParam {

    @Schema(description = "Key. Exact match.", example = "process1641042089407")
    private String key;

}
