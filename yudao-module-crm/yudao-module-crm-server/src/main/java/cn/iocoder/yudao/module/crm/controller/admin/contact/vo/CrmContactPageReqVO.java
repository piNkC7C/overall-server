package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM contact page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmContactPageReqVO extends PageParam {

    @Schema(description = "Name", example = "Overall.")
    private String name;

    @Schema(description = "Customer code.", example = "10795")
    private Long customerId;

    @Schema(description = "Phone number.", example = "13898273941")
    private String mobile;

    @Schema(description = "Phone", example = "021-383773")
    private String telephone;

    @Schema(description = "Email", example = "111@22.com")
    private String email;

    @Schema(description = "QQ", example = "3882872")
    private Long qq;

    @Schema(description = "WeChat", example = "zzZ98373")
    private String wechat;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Opportunity code.", example = "10430")
    private Long businessId;

}
