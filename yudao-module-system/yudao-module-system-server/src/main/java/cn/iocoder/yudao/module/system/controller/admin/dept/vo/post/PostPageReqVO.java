package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - post page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class PostPageReqVO extends PageParam {

    @Schema(description = "Post code, fuzzy match.", example = "yudao")
    private String code;

    @Schema(description = "Post name, fuzzy match.", example = "Overall.")
    private String name;

    @Schema(description = "Display status. See CommonStatusEnum.", example = "1")
    private Integer status;

}
