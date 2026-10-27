package cn.iocoder.yudao.module.system.controller.admin.dict.vo.data;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - dictionary type page list request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDataPageReqVO extends PageParam {

    @Schema(description = "Dictionarytag.", example = "Overall.")
    @Size(max = 100, message = "Dictionarytag length cannot exceed 100 characters.")
    private String label;

    @Schema(description = "Dictionary type, fuzzy match.", example = "sys_common_sex")
    @Size(max = 100, message = "Dictionary type type length cannot exceed 100 characters.")
    private String dictType;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

}
