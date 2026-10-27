package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - decorate templatecreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyTemplateCreateReqVO extends DiyTemplateBaseVO {

}
