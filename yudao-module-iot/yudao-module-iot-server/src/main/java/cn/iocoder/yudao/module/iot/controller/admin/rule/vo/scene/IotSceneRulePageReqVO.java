package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.scene;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IoT scene automation page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IotSceneRulePageReqVO extends PageParam {

    @Schema(description = "Scene name.", example = "Sam.")
    private String name;

    @Schema(description = "SceneDescription.", example = "Example.")
    private String description;

    @Schema(description = "Scene status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}