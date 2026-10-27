package cn.iocoder.yudao.module.iot.controller.admin.product.vo.category;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT product category response.")
@Data
public class IotProductCategoryRespVO {

    @Schema(description = "Category ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25284")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "Category sort.")
    private Integer sort;

    @Schema(description = "Category status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "CategoryDescription.", example = "Sample.")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}