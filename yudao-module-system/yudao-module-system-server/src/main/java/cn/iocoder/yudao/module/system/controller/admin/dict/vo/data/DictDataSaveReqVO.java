package cn.iocoder.yudao.module.system.controller.admin.dict.vo.data;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - 字典数据创建/修改 Request VO")
@Data
public class DictDataSaveReqVO {

    @Schema(description = "字典数据编号", example = "1024")
    private Long id;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "字典标签", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotBlank(message = "Dictionarytag is required.")
    @Size(max = 100, message = "Dictionarytag length cannot exceed 100 characters.")
    private String label;

    @Schema(description = "字典值", requiredMode = Schema.RequiredMode.REQUIRED, example = "iocoder")
    @NotBlank(message = "Dict value is required.")
    @Size(max = 100, message = "Dict value length cannot exceed 100 characters.")
    private String value;

    @Schema(description = "字典类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    @NotBlank(message = "Dictionary type is required.")
    @Size(max = 100, message = "Dictionary type length cannot exceed 100 characters.")
    private String dictType;

    @Schema(description = "状态,见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

    @Schema(description = "颜色类型,default、primary、success、info、warning、danger", example = "default")
    private String colorType;

    @Schema(description = "css 样式", example = "btn-visible")
    private String cssClass;

    @Schema(description = "备注", example = "Me is one role.")
    private String remark;

}
