package cn.iocoder.yudao.module.crm.controller.admin.clue.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - lead page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmCluePageReqVO extends PageParam {

    @Schema(description = "Lead name.", example = "Leadxxx.")
    private String name;

    @Schema(description = "Conversion status.", example = "2048")
    private Boolean transformStatus;

    @Schema(description = "Phone", example = "18000000000")
    private String telephone;

    @Schema(description = "Phone number.", example = "18000000000")
    private String mobile;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Industry", example = "1")
    private Integer industryId;

    @Schema(description = "Customer level.", example = "1")
    private Integer level;

    @Schema(description = "Customer source.", example = "1")
    private Integer source;

    @Schema(description = "Follow-up status.", example = "true")
    private Boolean followUpStatus;

    @Schema(description = "Create time.", example = "[2023-01-01 00:00:00, 2023-01-31 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
