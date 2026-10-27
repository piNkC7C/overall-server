package cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.dataType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * IoT 物模型数据类型为布尔型或枚举型的 DataSpec 定义
 *
 * 数据类型，取值为 bool 或 enum
 *
 * @author HUIHUI
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"dataType"}) // 忽略子类中的 dataType 字段，从而避免重复
public class ThingModelBoolOrEnumDataSpecs extends ThingModelDataSpecs {

    @NotEmpty(message = "Enum item name is required.")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z0-9][\\u4e00-\\u9fa5a-zA-Z0-9_-]{0,19}$",
            message = "Enum name may contain letters, digits, underscores, and hyphens, must start with a letter or digit, and cannot exceed 20 characters.")
    private String name;

    @NotNull(message = "Enum value cannot be empty.")
    private Integer value;

}
