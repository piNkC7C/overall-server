package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.common.FmsDebitCreditDirectionEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsSubjectCategoryEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsSubjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * FMS 科目保存 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - FMS 科目保存 Request VO")
@Data
public class FmsSubjectSaveReqVO {

    @Schema(description = "科目编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "科目编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @NotBlank(message = "Account code is required.")
    @Size(max = 64, message = "Account code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "科目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cash on hand")
    @NotBlank(message = "Account name is required.")
    @Size(max = 255, message = "Account name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "上级科目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent account ID cannot be empty.")
    private Long parentId;

    @Schema(description = "科目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Account type is required.")
    @InEnum(FmsSubjectTypeEnum.class)
    private Integer type;

    @Schema(description = "科目类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Account category cannot be empty.")
    private Integer category;

    @Schema(description = "余额方向", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Balance Direction is required.")
    @InEnum(FmsDebitCreditDirectionEnum.class)
    private Integer balanceDirection;

    @Schema(description = "辅助核算类别编号数组")
    @NotNull(message = "Auxiliary category IDArray is required.")
    private List<Long> auxiliaryTypeIds;

    @Schema(description = "外币核算币别编号数组")
    @NotNull(message = "Foreign-currency IDs cannot be empty.")
    private List<Long> currencyIds;

    @Schema(description = "是否启用数量核算", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not Enabled quantity accounting is required.")
    private Boolean quantityAccounting;

    @Schema(description = "数量单位", example = "Pcs.")
    @Size(max = 255, message = "Quantity order characters length cannot exceed 255 characters.")
    private String quantityUnit;

    @Schema(description = "是否现金及现金等价物", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Cash or cash equivalent cannot be empty.")
    private Boolean cash;

    @Schema(description = "是否迁移上级科目历史数据")
    private Boolean migrateParentData;

    @Schema(description = "辅助核算历史数据迁移项目数组")
    private List<AuxiliaryMapping> auxiliaryMappings;

    @AssertTrue(message = "Account category does not match the account type.")
    public boolean isCategoryValid() {
        return type == null || category == null || FmsSubjectCategoryEnum.valueOf(type, category) != null;
    }

    @AssertTrue(message = "Enabled quantity accounting time quantity order characters is required.")
    public boolean isQuantityUnitValid() {
        return !Boolean.TRUE.equals(quantityAccounting) || StrUtil.isNotBlank(quantityUnit);
    }

    /**
     * 辅助核算历史数据迁移项目
     */
    @Data
    public static class AuxiliaryMapping {

        @Schema(description = "辅助核算类别编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Auxiliary category ID is required.")
        private Long typeId;

        @Schema(description = "辅助核算项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Auxiliary accounting item code is required.")
        private Long itemId;

    }

}
