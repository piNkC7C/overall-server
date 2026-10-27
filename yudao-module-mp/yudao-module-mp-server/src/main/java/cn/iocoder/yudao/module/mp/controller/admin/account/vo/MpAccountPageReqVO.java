package cn.iocoder.yudao.module.mp.controller.admin.account.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Official Account account page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpAccountPageReqVO extends PageParam {

    @Schema(name = "Official Account name.", description = "Fuzzy match.")
    private String name;

    @Schema(name = "Official Account account.", description = "Fuzzy match.")
    private String account;

    @Schema(name = "Official Account appid.", description = "Fuzzy match.")
    private String appId;

}
