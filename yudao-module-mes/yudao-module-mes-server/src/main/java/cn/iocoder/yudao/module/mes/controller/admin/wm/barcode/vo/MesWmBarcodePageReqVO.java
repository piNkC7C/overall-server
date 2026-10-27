package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "MES barcode list page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmBarcodePageReqVO extends PageParam {

    @Schema(description = "Barcode setting code.", example = "1")
    private Long configId;

    @Schema(description = "Barcode format.", example = "1")
    private Integer format;

    @Schema(description = "Business type.", example = "102")
    private Integer bizType;

    @Schema(description = "Barcode content.", example = "WH-WH001")
    private String content;

    @Schema(description = "Business code.", example = "1024")
    private Long bizId;

    @Schema(description = "Business code.", example = "WH001")
    private String bizCode;

    @Schema(description = "Business name.", example = "Raw Materials.")
    private String bizName;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
