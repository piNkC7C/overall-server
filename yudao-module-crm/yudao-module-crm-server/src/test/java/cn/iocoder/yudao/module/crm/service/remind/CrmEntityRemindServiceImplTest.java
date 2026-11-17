package cn.iocoder.yudao.module.crm.service.remind;

import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerPoolConfigDO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link CrmEntityRemindServiceImpl} 开火时间计算单测
 */
public class CrmEntityRemindServiceImplTest {

    @Test
    public void testEarliestPoolFireAt_usesContactLastTime() {
        LocalDateTime ownerTime = LocalDateTime.of(2026, 11, 1, 10, 0);
        LocalDateTime lastContact = LocalDateTime.of(2026, 11, 10, 9, 0);
        CrmCustomerDO customer = new CrmCustomerDO().setOwnerTime(ownerTime).setContactLastTime(lastContact);
        CrmCustomerPoolConfigDO config = new CrmCustomerPoolConfigDO()
                .setContactExpireDays(7).setDealExpireDays(30).setNotifyDays(2);

        // 跟进：lastContact + (7-2) = 11-15；成交：owner + (30-2) = 11-29 → 取更早
        LocalDateTime fireAt = CrmEntityRemindServiceImpl.earliestPoolFireAt(customer, config);
        assertEquals(LocalDateTime.of(2026, 11, 15, 9, 0), fireAt);
    }

    @Test
    public void testEarliestPoolFireAt_nullContactUsesOwnerTime() {
        LocalDateTime ownerTime = LocalDateTime.of(2026, 11, 1, 10, 0);
        CrmCustomerDO customer = new CrmCustomerDO().setOwnerTime(ownerTime).setContactLastTime(null);
        CrmCustomerPoolConfigDO config = new CrmCustomerPoolConfigDO()
                .setContactExpireDays(7).setDealExpireDays(30).setNotifyDays(2);

        LocalDateTime fireAt = CrmEntityRemindServiceImpl.earliestPoolFireAt(customer, config);
        // contact: owner+(7-2)=11-06；deal: owner+(30-2)=11-29
        assertEquals(LocalDateTime.of(2026, 11, 6, 10, 0), fireAt);
    }

    @Test
    public void testEarliestPoolPutAt_afterFire() {
        LocalDateTime ownerTime = LocalDateTime.of(2026, 11, 1, 10, 0);
        CrmCustomerDO customer = new CrmCustomerDO().setOwnerTime(ownerTime);
        CrmCustomerPoolConfigDO config = new CrmCustomerPoolConfigDO()
                .setContactExpireDays(7).setDealExpireDays(30).setNotifyDays(2);

        LocalDateTime fireAt = CrmEntityRemindServiceImpl.earliestPoolFireAt(customer, config);
        LocalDateTime putAt = CrmEntityRemindServiceImpl.earliestPoolPutAt(customer, config);
        assertNotNull(fireAt);
        assertNotNull(putAt);
        assertTrue(fireAt.isBefore(putAt));
        assertEquals(LocalDateTime.of(2026, 11, 8, 10, 0), putAt);
    }

}
