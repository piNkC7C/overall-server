package cn.iocoder.yudao.module.mp.controller.admin.news.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - Official Account draft page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpDraftPageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

}
