package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.config;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - MES barcode setting page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmBarcodeConfigPageReqVO extends PageParam {

    @Schema(description = "Barcode format.", example = "1")
    private Integer format;

    @Schema(description = "Business type.", example = "102")
    private Integer bizType;

    @Schema(description = "Is not Autocreate.", example = "true")
    private Boolean autoGenerateFlag;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
