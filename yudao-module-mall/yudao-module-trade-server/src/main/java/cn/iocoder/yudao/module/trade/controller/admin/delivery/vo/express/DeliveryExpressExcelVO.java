package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.express;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

/**
 * 快递公司 Excel VO
 */
@Data
public class DeliveryExpressExcelVO {

    @ExcelProperty("Code")
    private Long id;

    @ExcelProperty("Carrier Code")
    private String code;

    @ExcelProperty("Carrier Name")
    private String name;

    @ExcelProperty("Carrier Logo")
    private String logo;

    @ExcelProperty("Sort")
    private Integer sort;

    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
