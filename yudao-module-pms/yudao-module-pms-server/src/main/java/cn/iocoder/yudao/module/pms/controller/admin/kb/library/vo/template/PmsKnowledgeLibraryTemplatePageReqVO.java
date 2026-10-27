package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - PMS knowledge base template page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsKnowledgeLibraryTemplatePageReqVO extends PageParam {

    @Schema(description = "Template name, fuzzy match.", example = "Product R&D")
    private String name;

    @Schema(description = "Template status.", example = "0")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
