package cn.iocoder.yudao.module.mp.controller.admin.tag.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official Accounttagupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpTagUpdateReqVO extends MpTagBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Code is required.")
    private Long id;

}
