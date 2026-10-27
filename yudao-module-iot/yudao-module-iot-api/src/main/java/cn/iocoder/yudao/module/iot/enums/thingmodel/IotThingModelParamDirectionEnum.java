package cn.iocoder.yudao.module.iot.enums.thingmodel;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


/**
 * IoT 产品物模型参数是输入参数还是输出参数枚举
 *
 * @author HUIHUI
 */
@AllArgsConstructor
@Getter
public enum IotThingModelParamDirectionEnum implements ArrayValuable<String> {

    INPUT("input"), // Input Params
    OUTPUT("output"); // Output Params

    public static final String[] ARRAYS = Arrays.stream(values()).map(IotThingModelParamDirectionEnum::getDirection).toArray(String[]::new);

    private final String direction;

    @Override
    public String[] array() {
        return ARRAYS;
    }

}
