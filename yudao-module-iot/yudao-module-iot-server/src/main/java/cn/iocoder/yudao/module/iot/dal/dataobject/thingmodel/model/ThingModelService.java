package cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelServiceCallTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * IoT 物模型中的服务
 *
 * @author HUIHUI
 */
@Data
public class ThingModelService {

    /**
     * 服务标识符
     */
    @NotEmpty(message = "Service identifier is required.")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,31}$", message = "Service identifier can only by letters 、 digits and underscore consist of, must letters start, length not exceeds 32 characters.")
    private String identifier;
    /**
     * 服务名称
     */
    @NotEmpty(message = "Service name is required.")
    private String name;
    /**
     * 是否是标准品类的必选服务
     */
    private Boolean required;
    /**
     * 调用类型
     *
     * 枚举 {@link IotThingModelServiceCallTypeEnum}
     */
    @NotEmpty(message = "Call type is required.")
    @InEnum(IotThingModelServiceCallTypeEnum.class)
    private String callType;
    /**
     * 服务的输入参数
     *
     * 输入参数定义服务调用时所需提供的信息，用于控制设备行为或执行特定任务
     */
    @Valid
    private List<ThingModelParam> inputParams;
    /**
     * 服务的输出参数
     *
     * 输出参数定义服务调用后返回的结果或反馈信息，用于确认操作结果或提供额外的信息。
     */
    @Valid
    private List<ThingModelParam> outputParams;
    /**
     * 标识设备需要执行的具体操作
     */
    private String method;

}
