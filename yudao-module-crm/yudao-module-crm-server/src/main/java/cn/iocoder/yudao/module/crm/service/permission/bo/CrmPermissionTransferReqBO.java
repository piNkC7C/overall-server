package cn.iocoder.yudao.module.crm.service.permission.bo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据权限转移 Request BO
 *
 * @author HUIHUI
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmPermissionTransferReqBO {

    /**
     * 当前登录用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;

    /**
     * CRM 类型
     */
    @NotNull(message = "Crm type is required.")
    @InEnum(CrmBizTypeEnum.class)
    private Integer bizType;
    /**
     * 数据编号
     */
    @NotNull(message = "CRM data code is required.")
    private Long bizId;

    /**
     * 新负责人的用户编号
     */
    @NotNull(message = "New owner user ID cannot be empty.")
    private Long newOwnerUserId;

    /**
     * 老负责人加入团队后的权限级别。如果 null 说明移除
     *
     * 关联 {@link CrmPermissionLevelEnum}
     */
    private Integer oldOwnerPermissionLevel;

}
