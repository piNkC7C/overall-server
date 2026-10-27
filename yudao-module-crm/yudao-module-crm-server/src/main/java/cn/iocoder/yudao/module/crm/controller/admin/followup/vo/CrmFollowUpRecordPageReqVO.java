package cn.iocoder.yudao.module.crm.controller.admin.followup.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Follow-uprecord page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmFollowUpRecordPageReqVO extends PageParam {

    @Schema(description = "Data type.", example = "2")
    private Integer bizType;

    @Schema(description = "Data code.", example = "5564")
    private Long bizId;

}