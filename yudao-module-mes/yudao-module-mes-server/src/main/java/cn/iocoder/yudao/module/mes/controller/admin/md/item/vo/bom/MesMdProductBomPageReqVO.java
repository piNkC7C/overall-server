package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.bom;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES productBOM page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdProductBomPageReqVO extends PageParam {

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "Is not Enabled.", example = "0")
    private Integer status;

}
