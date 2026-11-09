package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.apply;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.supply.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 用品领用申请新增/修改 Request VO")
@Data
public class OaSupplyApplySaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "领用日期", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Issue date cannot be empty.")
    private LocalDateTime applyTime;

    @Schema(description = "使用类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Used type is required.")
    @InEnum(value = OaSupplyUseTypeEnum.class, message = "Used type must be {value}.")
    private Integer useType;

    @Schema(description = "领取方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Claim Method is required.")
    @Min(value = 1, message = "Claim method cannot be less than {value}.")
    private Integer pickupMethod;

    @Schema(description = "申请事由", requiredMode = Schema.RequiredMode.REQUIRED, example = "Issue daily office supplies to the department")
    @NotBlank(message = "Request Reason is required.")
    @Size(max = 500, message = "Request Reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 10, message = "AttachmentAddress list quantity cannot exceed {max}.")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "领用明细", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Issue lines cannot be empty.")
    @Valid
    private List<@NotNull(message = "Issue lines cannot be empty.") Item> items;

    @Schema(description = "管理后台 - 用品申请明细 Request VO")
    @Data
    public static class Item {

        @Schema(description = "办公用品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Office supply cannot be empty.")
        private Long itemId;

        @Schema(description = "领用数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Issue quantity cannot be empty.")
        @Min(value = 1, message = "Issue quantity cannot be less than 1.")
        private Integer applyQuantity;

    }

}
