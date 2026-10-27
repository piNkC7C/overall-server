package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.channel;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM Recruiting Channel page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmRecruitChannelPageReqVO extends PageParam {

    @Schema(description = "Channel name, fuzzy match.", example = "BOSS")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
