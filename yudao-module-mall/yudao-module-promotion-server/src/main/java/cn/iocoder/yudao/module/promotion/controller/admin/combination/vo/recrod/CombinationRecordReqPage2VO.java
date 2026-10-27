package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.recrod;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - group buy record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationRecordReqPage2VO extends PageParam {

    @Schema(description = "Group-leader ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group-leader ID cannot be empty.")
    private Long headId;

}
