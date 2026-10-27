package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM performance review resulttemplate page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformanceResultTemplatePageReqVO extends PageParam {

    @Schema(description = "Resulttemplate name, fuzzy match.", example = "Quarter")
    private String name;

}
