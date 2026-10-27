package cn.iocoder.yudao.module.mp.controller.admin.menu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Schema(description = "Admin - Official Accountmenu response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpMenuRespVO extends MpMenuBaseVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long accountId;

    @Schema(description = "Official Account appId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx1234567890ox")
    private String appId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
