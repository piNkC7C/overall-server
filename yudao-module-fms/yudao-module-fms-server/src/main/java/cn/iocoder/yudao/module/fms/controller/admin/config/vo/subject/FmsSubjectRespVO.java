package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.StringListConvert;
import cn.iocoder.yudao.module.fms.enums.DictTypeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.module.infra.enums.DictTypeConstants.BOOLEAN_STRING;

/**
 * FMS 科目 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS account response.")
@Data
@ExcelIgnoreUnannotated
public class FmsSubjectRespVO {

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @ExcelProperty(value = "Code", index = 0)
    private String code;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cash on hand")
    @ExcelProperty(value = "Name", index = 1)
    private String name;

    @Schema(description = "Parent account ID.", example = "1024")
    private Long parentId;

    @Schema(description = "Account type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Account category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer category;

    @JsonIgnore // 仅 excel 导出使用
    @ExcelProperty(value = "Category", index = 2, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SUBJECT_CATEGORY)
    private String categoryDictValue;

    @Schema(description = "Balance Direction.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Balance Side", index = 3, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.DEBIT_CREDIT_DIRECTION)
    private Integer balanceDirection;

    @Schema(description = "Auxiliary category IDArray.")
    private List<Long> auxiliaryTypeIds;

    @Schema(description = "Foreign-currency IDs.")
    private List<Long> currencyIds;

    @Schema(description = "Is not Enabled quantity accounting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean quantityAccounting;

    @Schema(description = "Quantity order characters.", example = "Pcs.")
    @ExcelProperty(value = "Quantity", index = 5)
    private String quantityUnit;

    @Schema(description = "Cash or cash equivalent.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "Cash Item", index = 6, converter = DictConvert.class)
    @DictFormat(BOOLEAN_STRING)
    private Boolean cash;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Auxiliary accounting typenameArray.")
    @ExcelProperty(value = "Auxiliary Accounting", index = 4, converter = StringListConvert.class)
    private List<String> auxiliaryTypeNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
