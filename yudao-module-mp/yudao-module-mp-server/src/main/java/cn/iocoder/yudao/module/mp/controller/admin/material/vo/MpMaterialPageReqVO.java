package cn.iocoder.yudao.module.mp.controller.admin.material.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official Accountmedia page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpMaterialPageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

    @Schema(description = "Permanent.", example = "true")
    private Boolean permanent;

    @Schema(description = "File type see WxConsts.MediaFileType enum.", example = "image")
    private String type;

}
