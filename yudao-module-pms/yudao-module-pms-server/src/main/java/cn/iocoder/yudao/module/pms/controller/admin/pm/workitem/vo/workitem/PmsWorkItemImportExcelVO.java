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
@Schema(description = "管理后台 - PMS 工作项 Excel 导入 VO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class PmsWorkItemImportExcelVO {

    @ExcelProperty("Item Title")
    @Schema(description = "工作项标题", example = "Finish the sign-in page")
    private String name;

    @ExcelProperty("Description")
    @Schema(description = "工作项描述", example = "Implement username-password sign-in")
    private String description;

    @ExcelProperty("Handler User ID")
    @Schema(description = "处理人用户编号，为空时不指定处理人", example = "1024")
    private Long assigneeUserId;

    @ExcelProperty("Status")
    @Schema(description = "项目状态名称；为空时使用项目默认状态", example = "Pending")
    private String statusName;

    @ExcelProperty(value = "Priority", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PMS_WORK_ITEM_PRIORITY)
    @ExcelColumnSelect(dictType = DictTypeConstants.PMS_WORK_ITEM_PRIORITY)
    @Schema(description = "优先级，Excel 中填写字典标签", example = "")
    private Integer priority;

    @ExcelProperty("Start Time")
    @Schema(description = "开始时间", example = "2026-08-30 09:00:00")
    private LocalDateTime startTime;

    @ExcelProperty("Due Time")
    @Schema(description = "截止时间", example = "2026-09-01 18:00:00")
    private LocalDateTime endTime;

    @ExcelProperty(value = "Tag", converter = StringListConvert.class)
    @Schema(description = "标签名称列表，多个标签可用逗号、顿号或斜杠分隔", example = "Frontend / sign-in.")
    private List<String> labels;

    @ExcelProperty("Progress")
    @Schema(description = "完成进度，范围 0-100", example = "50")
    private Integer progress;

    @ExcelProperty("Estimated Hours")
    @Schema(description = "预估工时，单位：小时", example = "8")
    private Integer estimatedHours;

    @ExcelProperty("Actual Hours")
    @Schema(description = "实际投入时长，单位：小时", example = "4")
    @Min(value = 1, message = "Actual duration must be greater than 0.")
    private Integer actualHours;

    @ExcelProperty("Remaining Hours")
    @Schema(description = "剩余工时，单位：小时", example = "4")
    @Min(value = 0, message = "Remaining hours cannot be less than 0.")
    private Integer remainingHours;

    @ExcelProperty(value = "Defect Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PMS_WORK_ITEM_DEFECT_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.PMS_WORK_ITEM_DEFECT_TYPE)
    @Schema(description = "缺陷类型，Excel 中填写字典标签，仅缺陷工作项使用", example = "Feature defect.")
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
