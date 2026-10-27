package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - WMS product list request.")
@Data
public class WmsItemListReqVO {

    @Schema(description = "Product code.", example = "ITEM001")
    private String code;

    @Schema(description = "Product name.", example = "Huawei nova flip.")
    private String name;

    @Schema(description = "Product category code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Product brand code.", example = "2048")
    private Long brandId;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
