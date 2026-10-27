package cn.iocoder.yudao.module.mp.controller.admin.tag.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Admin - Official Accounttag page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpTagPageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotEmpty(message = "Official Account account code is required.")
    private Long accountId;

    @Schema(description = "Tag name, fuzzy match.", example = "Haha")
    private String name;

}
