package cn.iocoder.yudao.module.crm.service.permission.bo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * crm 数据权限 Create Req BO
 *
 * @author HUIHUI
 */
@Data
public class CrmPermissionCreateReqBO {

    /**
     * 当前登录用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;

    /**
     * Crm 类型
     */
    @NotNull(message = "Crm type is required.")
    @InEnum(CrmBizTypeEnum.class)
    private Integer bizType;
    /**
     * 数据编号
     */
    @NotNull(message = "Crm data code is required.")
    private Long bizId;

    /**
     * 权限级别
     */
    @NotNull(message = "Permission level is required.")
    @InEnum(CrmPermissionLevelEnum.class)
    private Integer level;

}
