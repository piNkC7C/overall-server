package cn.iocoder.yudao.module.system.controller.admin.notice.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - notificationannouncement page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticePageReqVO extends PageParam {

    @Schema(description = "Notificationannouncement name, fuzzy match.", example = "Overall.")
    private String title;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

}
