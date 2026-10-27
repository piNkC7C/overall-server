package cn.iocoder.yudao.module.oa.enums.mail;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 企业邮箱文件夹类型枚举
 *
 * 将服务商的远端目录映射为本地业务类型，未读邮件不属于实际文件夹。
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaMailFolderTypeEnum implements ArrayValuable<String> {

    INBOX("INBOX", "Inbox"),
    SENT("SENT", "Already send."),
    DRAFTS("DRAFTS", "Drafts"),
    TRASH("TRASH", "Already delete."),
    CUSTOM("CUSTOM", "Custom folder");

    public static final String[] ARRAYS = Arrays.stream(values())
            .map(OaMailFolderTypeEnum::getType).toArray(String[]::new);

    /**
     * 类型
     */
    private final String type;
    /**
     * 名称
     */
    private final String name;

    /**
     * 获得自定义目录的同步标识
     *
     * @param fullName 远端完整路径
     * @return 同步标识
     */
    public static String getCustomKey(String fullName) {
        return CUSTOM.getType() + ":" + fullName;
    }

    @Override
    public String[] array() {
        return ARRAYS;
    }

}
