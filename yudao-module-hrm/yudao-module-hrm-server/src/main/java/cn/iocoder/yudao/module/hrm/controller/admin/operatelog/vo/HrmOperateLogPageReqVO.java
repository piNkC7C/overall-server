package cn.iocoder.yudao.module.hrm.controller.admin.operatelog.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.common.HrmBizTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - HRM Activity Log page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HrmOperateLogPageReqVO extends PageParam {

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(HrmBizTypeEnum.class)
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Business code is required.")
    private Long bizId;

}
