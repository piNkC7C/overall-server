package cn.iocoder.yudao.module.aimonitor.dal.dataobject.project;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * AI 监测项目（绑定算法 project id）。
 * 行归属用 BaseDO.creator（登录用户 id），列表/详情仅本人可见；不向前端展示。
 */
@TableName("aimonitor_project")
@KeySequence("aimonitor_project_seq")
@Data
@EqualsAndHashCode(callSuper = true)
public class AimonitorProjectDO extends TenantBaseDO {

    @TableId
    private Long id;
    /** 算法侧 Project.id */
    private String algorithmProjectId;
    private String name;
    private String brandName;
    private String website;
    private String country;
    /** active / paused / archived */
    private String status;
    private String platforms;
    private String category;
    private String businessType;
    private Integer scanCount;
    private LocalDateTime lastScanAt;
    private String remark;

}
