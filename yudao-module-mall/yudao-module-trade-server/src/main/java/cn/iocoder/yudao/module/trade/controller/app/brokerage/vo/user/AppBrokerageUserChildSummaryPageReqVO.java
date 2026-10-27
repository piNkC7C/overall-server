package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.SortingField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Downline reseller stats page request VO.")
@Data
public class AppBrokerageUserChildSummaryPageReqVO extends PageParam {

    public static final String SORT_FIELD_USER_COUNT = "userCount";
    public static final String SORT_FIELD_ORDER_COUNT = "orderCount";
    public static final String SORT_FIELD_PRICE = "price";

    @Schema(description = "Nickname", example = "Li") // Fuzzy match
    private String nickname;

    @Schema(description = "Sort field.", example = "userCount")
    private SortingField sortingField;

    @Schema(description = "Child level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1") // 1 - 直接下级；2 - 间接下级
    @NotNull(message = "Child level cannot be empty.")
    @Range(min = 1, max = 2, message = "Child level must be {min} or {max}.")
    private Integer level;

}
