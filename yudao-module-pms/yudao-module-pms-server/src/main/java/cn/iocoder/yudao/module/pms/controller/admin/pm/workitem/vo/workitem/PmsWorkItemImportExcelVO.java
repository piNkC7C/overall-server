package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.annotations.ExcelColumnSelect;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.excel.core.convert.StringListConvert;
import cn.iocoder.yudao.module.pms.enums.DictTypeConstants;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * PMS 工作项 Excel 导入 VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - PMS work item Excel import VO.")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class PmsWorkItemImportExcelVO {

    @ExcelProperty("Item Title")
    @Schema(description = "Work item title.", example = "Finish the sign-in page")
    private String name;

    @ExcelProperty("Description")
    @Schema(description = "Work item Description.", example = "Implement username-password sign-in")
    private String description;

    @ExcelProperty("Handler User ID")
    @Schema(description = "Process person user ID, is empty time not specified process person.", example = "1024")
    private Long assigneeUserId;

    @ExcelProperty("Status")
    @Schema(description = "Item status name; is empty time used item default status.", example = "Pending")
    private String statusName;

    @ExcelProperty(value = "Priority", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PMS_WORK_ITEM_PRIORITY)
    @ExcelColumnSelect(dictType = DictTypeConstants.PMS_WORK_ITEM_PRIORITY)
    @Schema(description = "Priority, Excel enter dictionarytag.", example = "")
    private Integer priority;

    @ExcelProperty("Start Time")
    @Schema(description = "Start time.", example = "2026-08-30 09:00:00")
    private LocalDateTime startTime;

    @ExcelProperty("Due Time")
    @Schema(description = "Due time.", example = "2026-09-01 18:00:00")
    private LocalDateTime endTime;

    @ExcelProperty(value = "Tag", converter = StringListConvert.class)
    @Schema(description = "Tag names. Separate with commas, enumeration commas, or slashes.", example = "Frontend / sign-in.")
    private List<String> labels;

    @ExcelProperty("Progress")
    @Schema(description = "Complete progress, Range 0-100.", example = "50")
    private Integer progress;

    @ExcelProperty("Estimated Hours")
    @Schema(description = "Estimated hours.", example = "8")
    private Integer estimatedHours;

    @ExcelProperty("Actual Hours")
    @Schema(description = "Actual duration, in hours.", example = "4")
    @Min(value = 1, message = "Actual duration must be greater than 0.")
    private Integer actualHours;

    @ExcelProperty("Remaining Hours")
    @Schema(description = "Remaining hours, in hours.", example = "4")
    @Min(value = 0, message = "Remaining hours cannot be less than 0.")
    private Integer remainingHours;

    @ExcelProperty(value = "Defect Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PMS_WORK_ITEM_DEFECT_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.PMS_WORK_ITEM_DEFECT_TYPE)
    @Schema(description = "Bug type. Enter the dictionary label in Excel. Bug work items only.", example = "Feature defect.")
    private Integer defectType;

    /**
     * 导入时从 {@link #statusName} 解析出的项目状态编号，不作为 Excel 列
     */
    @Schema(hidden = true)
    private Long statusId;

    /**
     * 导入时从 {@link #labels} 解析出的标签编号列表，不作为 Excel 列
     */
    @Schema(hidden = true)
    private List<Long> labelIds;

    /**
     * 导入时使用的工作项类型，不作为 Excel 列
     */
    @Schema(hidden = true)
    private Integer workItemType;

    @AssertTrue(message = "Actual duration is required when remaining hours are set.")
    public boolean isWorkLogHoursValid() {
        return actualHours != null || remainingHours == null;
    }

    @AssertTrue(message = "Defect type can be used only on defect work items.")
    public boolean isDefectTypeValid() {
        return defectType == null || PmsWorkItemTypeEnum.DEFECT.getType().equals(workItemType);
    }

}
