package cn.iocoder.yudao.module.promotion.controller.admin.reward.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - spend-and-save campaign page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RewardActivityPageReqVO extends PageParam {

    @Schema(description = "Campaign title.", example = "Sold out")
    private String name;

    @Schema(description = "Campaign status.", example = "1")
    private Integer status;

}
