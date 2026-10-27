package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.page.DiyPagePropertyRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - decorate templateProperty response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyTemplatePropertyRespVO extends DiyTemplateBaseVO {

    @Schema(description = "Decorate template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    private Long id;

    @Schema(description = "Template attribute, JSON.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    private String property;

    @Schema(description = "Templatepage.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[]")
    private List<DiyPagePropertyRespVO> pages;

}
