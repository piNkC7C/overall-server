package cn.iocoder.yudao.module.crm.controller.admin.performance.vo.config;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.performance.CrmPerformanceConfigBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.performance.CrmPerformanceConfigObjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "CRM quota setting page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmPerformanceConfigPageReqVO extends PageParam {

    @Schema(description = "Target object code.", example = "1")
    private Long objectId;

    @Schema(description = "Target object type.", example = "2")
    @InEnum(value = CrmPerformanceConfigObjectTypeEnum.class, message = "Target object type, must be {value}.")
    private Integer objectType;

    @Schema(description = "Year.", example = "2026")
    private Integer year;

    @Schema(description = "Target type.", example = "5")
    @InEnum(value = CrmPerformanceConfigBizTypeEnum.class, message = "Target type, must be {value}.")
    private Integer bizType;

}
