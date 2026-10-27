package cn.iocoder.yudao.module.product.controller.app.spu.vo;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "User App - product SPU page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppProductSpuPageReqVO extends PageParam {

    public static final String SORT_FIELD_PRICE = "price";
    public static final String SORT_FIELD_SALES_COUNT = "salesCount";
    public static final String SORT_FIELD_CREATE_TIME = "createTime";

    @Schema(description = "Product SPU ID list.", example = "1,3,5")
    private List<Long> ids;

    @Schema(description = "Category code.", example = "1")
    private Long categoryId;

    @Schema(description = "Category ID list.", example = "1,2,3")
    private List<Long> categoryIds;

    @Schema(description = "Keyword.", example = "Looks good")
    private String keyword;

    @Schema(description = "Sort field.", example = "price") // 参见 AppProductSpuPageReqVO.SORT_FIELD_XXX 常量
    private String sortField;

    @Schema(description = "Sort method.", example = "true")
    private Boolean sortAsc;

    @AssertTrue(message = "Sort field is invalid.")
    @JsonIgnore
    public boolean isSortFieldValid() {
        if (StrUtil.isEmpty(sortField)) {
            return true;
        }
        return StrUtil.equalsAny(sortField, SORT_FIELD_PRICE, SORT_FIELD_SALES_COUNT, SORT_FIELD_CREATE_TIME);
    }

}
