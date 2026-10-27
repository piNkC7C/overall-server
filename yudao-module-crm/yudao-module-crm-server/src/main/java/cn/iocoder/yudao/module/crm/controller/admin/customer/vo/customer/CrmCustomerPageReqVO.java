package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM customer page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmCustomerPageReqVO extends PageParam {

    /**
     * 联系状态 - 今日需联系
     */
    public static final int CONTACT_TODAY = 1;
    /**
     * 联系状态 - 已逾期
     */
    public static final int CONTACT_EXPIRED = 2;
    /**
     * 联系状态 - 已联系
     */
    public static final int CONTACT_ALREADY = 3;

    @Schema(description = "Customer name.", example = "Sam.")
    private String name;

    @Schema(description = "Mobile", example = "18000000000")
    private String mobile;

    @Schema(description = "Industry", example = "1")
    private Integer industryId;

    @Schema(description = "Customer level.", example = "1")
    private Integer level;

    @Schema(description = "Customer source.", example = "1")
    private Integer source;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Pool data.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean pool; // null 则表示为不是公海数据

    @Schema(description = "Contact status.", example = "1")
    private Integer contactStatus; // Backlog search condition

    @Schema(description = "Follow-up status.", example = "true")
    private Boolean followUpStatus;

}
