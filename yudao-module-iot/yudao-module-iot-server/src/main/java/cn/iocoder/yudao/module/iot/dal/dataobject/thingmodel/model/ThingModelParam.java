package cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.dataType.ThingModelDataSpecs;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotDataSpecsDataTypeEnum;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelParamDirectionEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * IoT 产品物模型中的参数
 *
 * @author HUIHUI
 */
@Data
public class ThingModelParam {

    /**
     * 参数标识符
     */
    @NotEmpty(message = "Parameter identifier is required.")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,31}$", message = "Parameter identifier can only by letters 、 digits and underscore consist of, must letters start, length not exceeds 32 characters.")
    private String identifier;
    /**
     * 参数名称
     */
    @NotEmpty(message = "Parameter name is required.")
    private String name;
    /**
     * 用于区分输入或输出参数
     *
     * 枚举 {@link IotThingModelParamDirectionEnum}
     */
    @NotEmpty(message = "Parameter Direction is required.")
    @InEnum(IotThingModelParamDirectionEnum.class)
    private String direction;
    /**
     * 参数的序号。从 0 开始排序，且不能重复。
     *
     * TODO 考虑要不要序号，感觉是要的, 先留一手看看
     */
    private Integer paraOrder;
    /**
     * 参数值的数据类型，与 dataSpecs 的 dataType 保持一致
     *
     * 枚举 {@link IotDataSpecsDataTypeEnum}
     */
    @NotEmpty(message = "Data type is required.")
    @InEnum(IotDataSpecsDataTypeEnum.class)
    private String dataType;
    /**
     * 参数值的数据类型（dataType）为非列表型（int、float、double、text、date、array）的数据规范存储在 dataSpecs 中
     */
    private ThingModelDataSpecs dataSpecs;
    /**
     * 参数值的数据类型（dataType）为列表型（enum、bool、struct）的数据规范存储在 dataSpecsList 中
     */
    private List<ThingModelDataSpecs> dataSpecsList;

}
