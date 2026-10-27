package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Supplies issue record response VO.")
@Data
public class OaSupplyIssueRespVO {

    @Schema(description = "Detail code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Apply please code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long applyId;

    @Schema(description = "Supply ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long itemId;

    @Schema(description = "Item Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "A4 paper")
    private String itemName;

    @Schema(description = "Spec / Model", example = "A4 80g")
    private String model;

    @Schema(description = "Unit of measure.", example = "Bag")
    private String unit;

    @Schema(description = "Admin type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer manageType;

    @Schema(description = "Apply please quantity.", example = "1")
    private Integer applyQuantity;

    @Schema(description = "Issued Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer issuedQuantity;

    @Schema(description = "Returned quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer returnedQuantity;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "Issuer ID.", example = "1024")
    private Long issueUserId;

    @Schema(description = "Issuer.", example = "John.")
    private String issueUserName;

    @Schema(description = "Issued At.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime issueTime;

    @Schema(description = "Issue notes.", example = "Issued per the request lines")
    private String issueRemark;

    @Schema(description = "Return notes.", example = "Item is in good condition and returned to stock")
    private String returnRemark;

    @Schema(description = "Apply please order no.", example = "YC202609140001")
    private String no;

    @Schema(description = "Apply please person.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please department.", example = "Administration.")
    private String deptName;

    @Schema(description = "Used type.", example = "1")
    private Integer useType;

    @Schema(description = "Apply please time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
