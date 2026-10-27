package cn.iocoder.yudao.module.hrm.job.salary;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.hrm.service.salary.employee.HrmSalaryEmployeeInfoService;
import jakarta.annotation.Resource;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

/**
 * HRM 定薪调薪记录生效 Job
 *
 * @author 芋道源码
 */
@Component
public class HrmSalaryChangeJob {

    @Resource
    private HrmSalaryEmployeeInfoService salaryEmployeeInfoService;

    @XxlJob("hrmSalaryChangeJob")
    @TenantJob
    public String execute() {
        String param = XxlJobHelper.getJobParam();
        LocalDate targetDate = StrUtil.isBlank(param) ? LocalDate.now() : LocalDate.parse(param);

        // 1. 应用到期的调薪记录
        List<Long> employeeIds = salaryEmployeeInfoService.applyDueSalaryChanges(targetDate);

        // 2. 返回执行结果
        return String.format("HRM salary adjustments applied: date %s, %s records, %s employees",
                targetDate, employeeIds.size(), new HashSet<>(employeeIds).size());
    }

}
