package cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.enums.md.WmsMerchantTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Admin - WMS business partner page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsMerchantPageReqVO extends PageParam {

    @Schema(description = "Business partner code.", example = "MER001")
    private String code;

    @Schema(description = "Business partner name.", example = "Huawei")
    private String name;

    @Schema(description = "Business partner type.", example = "2")
    @InEnum(value = WmsMerchantTypeEnum.class, message = "Business partner type must be {value}.")
    private Integer type;

    @Schema(description = "Business partner typeArray.", example = "2,3")
    @InEnum(value = WmsMerchantTypeEnum.class, message = "Business partner type must be {value}.")
    private List<Integer> types;

}
