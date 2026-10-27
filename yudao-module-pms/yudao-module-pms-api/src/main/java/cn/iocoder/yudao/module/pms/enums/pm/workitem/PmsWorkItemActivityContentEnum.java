package cn.iocoder.yudao.module.pms.enums.pm.workitem;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PMS 工作项动态内容枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PmsWorkItemActivityContentEnum {

    WORK_ITEM_CREATED("Created a work item"),
    WORK_ITEM_FIELD_UPDATED("{} from 「{}」 edit is 「{}」."),
    WORK_ITEM_DESCRIPTION_UPDATED("Updated the work-item description"),
    WORK_ITEM_LABELS_UPDATED("Tag from 「{}」 edit is 「{}」."),
    WORK_ITEM_MEMBERS_UPDATED("Changed participants from 「{}」 to 「{}」"),
    WORK_ITEM_ATTACHMENTS_UPDATED("Attachment from 「{}」 edit is 「{}」."),
    WORK_ITEM_PARENT_UPDATED("Parent work item from 「{}」 edit is 「{}」."),
    WORK_ITEM_NAME_UPDATED("Work item name from 「{}」 edit is 「{}」."),
    WORK_ITEM_STATUS_UPDATED("Status from 「{}」 edit is 「{}」."),
    WORK_ITEM_MOVED_TO_BACKLOG("Moved the work item back to unplanned"),
    WORK_ITEM_PLANNED_TO_ITERATION("Planned the work item into a sprint"),
    WORK_ITEM_ARCHIVED("Archived the work item"),
    WORK_ITEM_RECYCLED("Moved the work item to trash"),
    WORK_ITEM_RESTORED("Restored the work item"),

    COMMENT_CREATED("Added a comment"),
    COMMENT_REPLIED("Replied to a comment"),
    COMMENT_UPDATED("Updated a comment"),
    COMMENT_DELETED("Deleted a comment"),

    WORK_LOG_CREATED("Logged {} hours"),
    WORK_LOG_UPDATED("Updated a time log");

    /**
     * 动态内容模板
     */
    private final String content;

    /**
     * 格式化动态内容
     *
     * @param arguments 模板参数
     * @return 动态内容
     */
    public String format(Object... arguments) {
        return StrUtil.format(content, arguments);
    }

}
