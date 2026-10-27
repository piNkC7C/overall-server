package cn.iocoder.yudao.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Schema(description="Page parameter.")
@Data
public class PageParam implements Serializable {

    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;

    /**
     * 每页条数 - 不分页
     *
     * 例如说，导出接口，可以设置 {@link #pageSize} 为 -1 不分页，查询所有数据。
     */
    public static final Integer PAGE_SIZE_NONE = -1;

    @Schema(description = "Page number, starting at 1.", requiredMode = Schema.RequiredMode.REQUIRED,example = "1")
    @NotNull(message = "Page number cannot be empty.")
    @Min(value = 1, message = "Page number minimum is 1.")
    private Integer pageNo = PAGE_NO;

    @Schema(description = "Page size. Max 200.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Page size cannot be empty.")
    @Min(value = 1, message = "Page size minimum is 1.")
    @Max(value = 200, message = "Page size maximum is 200.")
    private Integer pageSize = PAGE_SIZE;

}
