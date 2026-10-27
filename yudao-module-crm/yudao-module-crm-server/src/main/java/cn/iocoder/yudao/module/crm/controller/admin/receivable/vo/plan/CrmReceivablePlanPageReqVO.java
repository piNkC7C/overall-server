package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.plan;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM collectionplan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmReceivablePlanPageReqVO extends PageParam {

    /**
     * 提醒类型 - 待回款
     */
    public final static Integer REMIND_TYPE_NEEDED = 1;
    /**
     * 提醒类型 - 已逾期
     */
    public final static Integer REMIND_TYPE_EXPIRED = 2;
    /**
     * 提醒类型 - 已回款
     */
    public final static Integer REMIND_TYPE_RECEIVED = 3;

    @Schema(description = "Customer code.", example = "18026")
    private Long customerId;

    @Schema(description = "Contract code.", example = "H3473")
    private String contractNo;

    @Schema(description = "Contract code.", example = "3473")
    private Long contractId;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Reminder type.", example = "1")
    private Integer remindType; // 提醒类型，为 null 时则表示全部

}
