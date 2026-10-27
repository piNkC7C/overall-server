package cn.iocoder.yudao.module.system.enums.sms;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 用户短信验证码发送场景的枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum SmsSceneEnum implements ArrayValuable<Integer> {

    MEMBER_LOGIN(1, "user-sms-login", "Member - mobile sign-in"),
    MEMBER_UPDATE_MOBILE(2, "user-update-mobile", "Memberuser - edit Mobile."),
    MEMBER_UPDATE_PASSWORD(3, "user-update-password", "Memberuser - edit password."),
    MEMBER_RESET_PASSWORD(4, "user-reset-password", "Member - forgot password"),

    ADMIN_MEMBER_LOGIN(21, "admin-sms-login", "Admin - mobile sign-in"),
    ADMIN_MEMBER_REGISTER(22, "admin-sms-register", "Admin - mobile sign-up"),
    ADMIN_MEMBER_RESET_PASSWORD(23, "admin-reset-password", "Admin - forgot password");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(SmsSceneEnum::getScene).toArray(Integer[]::new);

    /**
     * 验证场景的编号
     */
    private final Integer scene;
    /**
     * 模版编码
     */
    private final String templateCode;
    /**
     * 描述
     */
    private final String description;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static SmsSceneEnum getCodeByScene(Integer scene) {
        return ArrayUtil.firstMatch(sceneEnum -> sceneEnum.getScene().equals(scene),
                values());
    }

}
