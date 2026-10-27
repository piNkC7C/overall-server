package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.product.CombinationProductBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - group buy campaignupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationActivityUpdateReqVO extends CombinationActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    @NotNull(message = "Campaign code is required.")
    private Long id;

    @Schema(description = "Group buy product.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private List<CombinationProductBaseVO> products;

}
