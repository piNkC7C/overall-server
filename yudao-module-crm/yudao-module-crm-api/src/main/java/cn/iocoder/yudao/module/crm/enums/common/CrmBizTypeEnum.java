package cn.iocoder.yudao.module.crm.enums.common;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * CRM 业务类型枚举
 *
 * @author HUIHUI
 */
@RequiredArgsConstructor
@Getter
public enum CrmBizTypeEnum implements ArrayValuable<Integer> {

    CRM_CLUE(1, "Lead"),
    CRM_CUSTOMER(2, "Customer"),
    CRM_CONTACT(3, "Contact"),
    CRM_BUSINESS(4, "Opportunity"),
    CRM_CONTRACT(5, "Contract"),
    CRM_PRODUCT(6, "Product"),
    CRM_RECEIVABLE(7, "Collection"),
    CRM_RECEIVABLE_PLAN(8, "Collectionplan")
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(CrmBizTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名称
     */
    private final String name;

    public static String getNameByType(Integer type) {
        CrmBizTypeEnum typeEnum = CollUtil.findOne(CollUtil.newArrayList(CrmBizTypeEnum.values()),
                item -> ObjUtil.equal(item.type, type));
        return typeEnum == null ? null : typeEnum.getName();
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
