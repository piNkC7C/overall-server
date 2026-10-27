package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - Letterhead templatepage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaOfficialDocTemplatePageReqVO extends PageParam {

    @Schema(description = "Template name.", example = "Admin outgoing-document template")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
