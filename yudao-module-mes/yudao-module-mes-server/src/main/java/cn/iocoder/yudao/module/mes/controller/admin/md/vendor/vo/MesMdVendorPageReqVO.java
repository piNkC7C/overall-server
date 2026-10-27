package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES supplier page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdVendorPageReqVO extends PageParam {

    @Schema(description = "Supplier code.", example = "V00101")
    private String code;

    @Schema(description = "Supplier name.", example = "Hailead")
    private String name;

    @Schema(description = "Supplier short name.", example = "Hailead")
    private String nickname;

    @Schema(description = "SupplierEnglish Name.", example = "HLD")
    private String englishName;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
