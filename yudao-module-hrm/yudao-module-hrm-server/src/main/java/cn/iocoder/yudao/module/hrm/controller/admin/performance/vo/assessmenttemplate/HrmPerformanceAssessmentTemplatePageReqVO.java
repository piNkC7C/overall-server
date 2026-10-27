package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessmenttemplate;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM performance reviewReviewtemplate page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformanceAssessmentTemplatePageReqVO extends PageParam {

    @Schema(description = "Template name, fuzzy match.", example = "Quarter")
    private String name;

}
