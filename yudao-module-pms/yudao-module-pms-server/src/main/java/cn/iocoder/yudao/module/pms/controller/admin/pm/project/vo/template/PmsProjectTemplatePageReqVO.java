package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - PMS item template page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsProjectTemplatePageReqVO extends PageParam {

    @Schema(description = "Template name, fuzzy match.", example = "Agile template")
    private String name;

    @Schema(description = "Item type.", example = "2")
    @InEnum(PmsProjectTypeEnum.class)
    private Integer projectType;

    @Schema(description = "Template status.", example = "0")
    private Integer status;

}
