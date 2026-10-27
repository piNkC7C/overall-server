package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.combination.CombinationRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "User App - group buy record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCombinationRecordPageReqVO extends PageParam {

    @Schema(description = "Group buy status.", example = "1")
    @InEnum(value = CombinationRecordStatusEnum.class, message = "Group buy status must be {value}.")
    private Integer status;

}
