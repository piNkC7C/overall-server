package cn.iocoder.yudao.module.oa.enums.announcement;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 公告类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaAnnouncementTypeEnum implements ArrayValuable<Integer> {

    ANNOUNCEMENT(1, "Announcement"),
    NOTICE(2, "Notification"),
    VOTE(3, "Poll");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaAnnouncementTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
