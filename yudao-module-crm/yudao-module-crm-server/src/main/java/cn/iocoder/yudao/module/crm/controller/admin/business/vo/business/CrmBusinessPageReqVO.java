package cn.iocoder.yudao.module.crm.controller.admin.business.vo.business;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - opportunity page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmBusinessPageReqVO extends PageParam {

    @Schema(description = "Opportunity name.", example = "Jane.")
    private String name;

    @Schema(description = "Customer code.", example = "10795")
    private Long customerId;

    @Schema(description = "Contact code.", example = "10795")
    private Long contactId;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

}
