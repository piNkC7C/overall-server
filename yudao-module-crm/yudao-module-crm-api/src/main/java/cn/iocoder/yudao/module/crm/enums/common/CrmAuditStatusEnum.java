package cn.iocoder.yudao.module.crm.enums.common;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * CRM 的审批状态
 *
 * @author 赤焰
 */
@RequiredArgsConstructor
@Getter
public enum CrmAuditStatusEnum implements ArrayValuable<Integer> {

    DRAFT(0, "Not submit."),
    PROCESS(10, "Approval."),
    APPROVE(20, "Approval via."),
	REJECT(30, "Approval not via."),
    CANCEL(40, "Canceled.");

    private final Integer status;
    private final String name;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(CrmAuditStatusEnum::getStatus).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
