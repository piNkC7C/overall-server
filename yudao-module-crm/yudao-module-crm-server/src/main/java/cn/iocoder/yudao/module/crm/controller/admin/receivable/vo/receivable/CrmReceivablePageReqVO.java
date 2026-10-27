package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmAuditStatusEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM collection page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmReceivablePageReqVO extends PageParam {

    @Schema(description = "Collection code.")
    private String no;

    @Schema(description = "Collectionplan code.", example = "31177")
    private Long planId;

    @Schema(description = "Customer code.", example = "4963")
    private Long customerId;

    @Schema(description = "Contract code.", example = "4963")
    private Long contractId;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Approval status.", example = "20")
    @InEnum(CrmAuditStatusEnum.class)
    private Integer auditStatus;

}
