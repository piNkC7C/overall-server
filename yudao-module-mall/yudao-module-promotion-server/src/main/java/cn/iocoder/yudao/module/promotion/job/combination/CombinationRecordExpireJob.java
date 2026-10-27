package cn.iocoder.yudao.module.promotion.job.combination;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.promotion.service.combination.CombinationRecordService;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

// TODO Overall：setting one Job
/**
 * 拼团过期 Job
 *
 * @author HUIHUI
 */
@Component
public class CombinationRecordExpireJob {

    @Resource
    private CombinationRecordService combinationRecordService;

    @XxlJob("combinationRecordExpireJob")
    @TenantJob // 多租户
    public String execute() {
        KeyValue<Integer, Integer> keyValue = combinationRecordService.expireCombinationRecord();
        return StrUtil.format("Expired {} group buys, virtual-completed {}", keyValue.getKey(), keyValue.getValue());
    }

}
