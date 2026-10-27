package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.activity;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - points shop campaign page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PointActivityPageReqVO extends PageParam {

    @Schema(description = "Campaign status.", example = "2")
    private Integer status;

}