package cn.iocoder.yudao.module.crm.controller.admin.operatelog.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM Activity Log request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmOperateLogPageReqVO extends PageParam {

    @Schema(description = "Data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @InEnum(CrmBizTypeEnum.class)
    @NotNull(message = "Data type is required.")
    private Integer bizType;

    @Schema(description = "Data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Data code is required.")
    private Long bizId;

}
