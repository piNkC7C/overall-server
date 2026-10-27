package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo.line;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * MES 装箱明细分页 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES packing detail page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmPackageLinePageReqVO extends PageParam {

    @Schema(description = "Packing order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Packing order ID is required.")
    private Long packageId;

}
