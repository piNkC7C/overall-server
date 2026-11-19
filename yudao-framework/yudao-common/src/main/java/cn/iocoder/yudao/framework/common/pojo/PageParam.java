package cn.iocoder.yudao.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Schema(description="分页参数")
@Data
public class PageParam implements Serializable {

    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;

    /**
     * 每页条数 - 不分页
     *
     * 仅供服务端内部设置（如导出）；HTTP 入参仍须 1～200。日历按时间窗拉全量请用专用 list 接口。
     */
    public static final Integer PAGE_SIZE_NONE = -1;

    @Schema(description = "页码，从 1 开始", requiredMode = Schema.RequiredMode.REQUIRED,example = "1")
    @NotNull(message = "Page number cannot be empty.")
    @Min(value = 1, message = "Page number minimum is 1.")
    private Integer pageNo = PAGE_NO;

    @Schema(description = "每页条数，最大值为 200", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Page size cannot be empty.")
    @Min(value = 1, message = "Page size minimum is 1.")
    @Max(value = 200, message = "Page size maximum is 200.")
    private Integer pageSize = PAGE_SIZE;

}
