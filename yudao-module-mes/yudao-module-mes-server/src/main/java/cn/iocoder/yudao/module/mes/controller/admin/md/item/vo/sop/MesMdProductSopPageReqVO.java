package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES productSOP page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdProductSopPageReqVO extends PageParam {

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "69")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "Title.", example = "Step 1")
    private String title;

}
