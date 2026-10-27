package cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.dataType;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelAccessModeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * IoT 物模型数据类型为 struct 的 DataSpec 定义
 *
 * @author HUIHUI
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"dataType"}) // 忽略子类中的 dataType 字段，从而避免重复
public class ThingModelStructDataSpecs extends ThingModelDataSpecs {

    @NotEmpty(message = "Attribute identifier is required.")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,31}$", message = "Attribute identifier can only by letters 、 digits and underscore consist of, must letters start, length not exceeds 32 characters.")
    private String identifier;

    @NotEmpty(message = "Attribute name is required.")
    private String name;

    @NotEmpty(message = "Action type is required.")
    @InEnum(IotThingModelAccessModeEnum.class)
    private String accessMode;

    /**
     * 是否是标准品类的必选服务
     */
    private Boolean required;

    @NotEmpty(message = "Data type is required.")
    @Pattern(regexp = "^(int|float|double|text|date|enum|bool)$", message = "Data type must is ：int、float、double、text、date、enum、bool.")
    private String childDataType;

    /**
     * 数据类型（dataType）为非列表型（int、float、double、text、date、array）的数据规范存储在 dataSpecs 中
     */
    @Valid
    private ThingModelDataSpecs dataSpecs;

    /**
     * 数据类型（dataType）为列表型（enum、bool、struct）的数据规范存储在 dataSpecsList 中
     */
    @Valid
    private List<ThingModelDataSpecs> dataSpecsList;

}

