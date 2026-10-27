package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - group buy campaign page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationActivityPageReqVO extends PageParam {

    @Schema(description = "Group buy name.", example = "Sam.")
    private String name;

    @Schema(description = "Campaign status.", example = "0")
    private Integer status;

}
