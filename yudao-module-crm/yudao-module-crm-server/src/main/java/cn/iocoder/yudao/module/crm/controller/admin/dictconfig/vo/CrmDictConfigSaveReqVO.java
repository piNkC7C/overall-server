package cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - CRM 字典枚举配置创建/修改 Request VO")
@Data
public class CrmDictConfigSaveReqVO {

    @Schema(description = "字典数据编号", example = "1474")
    private Long id;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "字典标签", requiredMode = Schema.RequiredMode.REQUIRED, example = "打电话")
    @NotBlank(message = "Dictionary label is required.")
    @Size(max = 100, message = "Dictionary label length cannot exceed 100 characters.")
    private String label;

    @Schema(description = "状态,见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

    @Schema(description = "颜色类型", example = "default")
    private String colorType;

    @Schema(description = "备注")
    private String remark;

}
