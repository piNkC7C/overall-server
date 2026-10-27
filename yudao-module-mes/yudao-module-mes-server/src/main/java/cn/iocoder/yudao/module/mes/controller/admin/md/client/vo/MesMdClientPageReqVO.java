package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES customer page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdClientPageReqVO extends PageParam {

    @Schema(description = "Customer code.", example = "C00184")
    private String code;

    @Schema(description = "Customer name.", example = "BYD")
    private String name;

    @Schema(description = "Customer short name.", example = "BYD")
    private String nickname;

    @Schema(description = "CustomerEnglish Name.", example = "BYD")
    private String englishName;

    @Schema(description = "Customer type.", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
