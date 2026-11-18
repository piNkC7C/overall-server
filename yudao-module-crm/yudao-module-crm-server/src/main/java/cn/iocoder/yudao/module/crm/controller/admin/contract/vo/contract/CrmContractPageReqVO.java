package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmAuditStatusEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - CRM 合同分页 Request VO")
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

    /** 联系状态 - 今日需联系（下次联系时间在今日） */
    public static final int CONTACT_TODAY = 1;
    /** 联系状态 - 已逾期（下次联系时间早于今日） */
    public static final int CONTACT_EXPIRED = 2;
    /** 联系状态 - 已联系（今日有跟进） */
    public static final int CONTACT_ALREADY = 3;

    @Schema(description = "合同编号", example = "XYZ008")
    private String no;

    @Schema(description = "合同名称", example = "Alex.")
    private String name;

    @Schema(description = "客户编号", example = "18336")
    private Long customerId;

    @Schema(description = "商机编号", example = "10864")
    private Long businessId;

    @Schema(description = "场景类型", example = "1")
    @InEnum(CrmSceneTypeEnum.class)
    private Integer sceneType; // 场景类型，为 null 时则表示全部

    @Schema(description = "审批状态", example = "20")
    @InEnum(CrmAuditStatusEnum.class)
    private Integer auditStatus;

    @Schema(description = "是否待我审批（审批人视角，非合同负责人）", example = "true")
    private Boolean awaitingMyAudit;

    @Schema(hidden = true) // 服务端按 BPM 审批人填充
    private Collection<String> processInstanceIds;

    @Schema(description = "过期类型", example = "1")
    private Integer expiryType; // 过期类型，为 null 时则表示全部

    @Schema(description = "下单日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderDate;

    @Schema(description = "联系状态", example = "1")
    private Integer contactStatus; // Backlog search condition

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
