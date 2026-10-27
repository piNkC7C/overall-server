package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.listener;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - BPM workflow listener page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmProcessListenerPageReqVO extends PageParam {

    @Schema(description = "Listener name.", example = "Sam.")
    private String name;

    @Schema(description = "Listener type.", example = "execution")
    private String type;

    @Schema(description = "Listen event.", example = "start")
    private String event;

    @Schema(description = "Status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}