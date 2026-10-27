package cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.dataType.ThingModelDataSpecs;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotDataSpecsDataTypeEnum;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelAccessModeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * IoT 物模型中的属性
 *
 * dataSpecs 和 dataSpecsList 之中必须传入且只能传入一个
 *
 * @author HUIHUI
 */
@Data
public class ThingModelProperty {

    /**
     * STRUCT、ARRAY 等 JSON 属性值的长度上限：按 UTF-8 编码后的字节数计算，不是字符数
     *
     * 1. 写入前：JSON 字符串超过该长度时，转换为 null，不写入该属性
     * 2. 各存储后端共用，例如说 TDengine 的 VARCHAR 长度
     *
     * 注意：TDengine 一行（所有列）有总长度上限，调大该长度，会减少一个产品可以定义的 STRUCT、ARRAY 属性数量
     */
    public static final int LENGTH_JSON = 1024;

    /**
     * 属性标识符
     */
    @NotEmpty(message = "Attribute identifier is required.")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,31}$", message = "Attribute identifier can only by letters 、 digits and underscore consist of, must letters start, length not exceeds 32 characters.")
    private String identifier;
    /**
     * 属性名称
     */
    @NotEmpty(message = "Attribute name is required.")
    private String name;
    /**
     * 云端可以对该属性进行的操作类型
     *
     * 枚举 {@link IotThingModelAccessModeEnum}
     */
    @NotEmpty(message = "Action type is required.")
    @InEnum(IotThingModelAccessModeEnum.class)
    private String accessMode;
    /**
     * 是否是标准品类的必选服务
     */
    private Boolean required;
    /**
     * 参数值的数据类型，与 dataSpecs 的 dataType 保持一致
     *
     * 枚举 {@link IotDataSpecsDataTypeEnum}
     */
    @NotEmpty(message = "Data type is required.")
    @InEnum(IotDataSpecsDataTypeEnum.class)
    private String dataType;
    /**
     * 数据类型（dataType）为非列表型（int、float、double、text、date、array）的数据规范存储在 dataSpecs 中
     */
    private ThingModelDataSpecs dataSpecs;
    /**
     * 数据类型（dataType）为列表型（enum、bool、struct）的数据规范存储在 dataSpecsList 中
     */
    private List<ThingModelDataSpecs> dataSpecsList;

}
