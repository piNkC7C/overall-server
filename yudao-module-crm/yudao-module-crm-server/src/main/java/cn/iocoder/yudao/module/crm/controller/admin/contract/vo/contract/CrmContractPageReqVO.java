package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmAuditStatusEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM contract page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmContractPageReqVO extends PageParam {

    /**
     * 过期类型 - 即将过期
     */
    public static final Integer EXPIRY_TYPE_ABOUT_TO_EXPIRE = 1;
    /**
     * 过期类型 - 已过期
     */
    public static  final Integer EXPIRY_TYPE_EXPIRED = 2;

    @Schema(description = "Contract code.", example = "XYZ008")
    private String no;

    @Schema(description = "Contract name.", example = "Alex.")
    private String name;

    @Schema(description = "Customer code.", example = "18336")
    private Long customerId;

    @Schema(description = "Opportunity code.", example = "10864")
    private Long businessId;

    @Schema(description = "Scene type", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "Approval status.", example = "20")
    @InEnum(CrmAuditStatusEnum.class)
    private Integer auditStatus;

    @Schema(description = "Expire type.", example = "1")
    private Integer expiryType; // 过期类型，为 null 时则表示全部

}
