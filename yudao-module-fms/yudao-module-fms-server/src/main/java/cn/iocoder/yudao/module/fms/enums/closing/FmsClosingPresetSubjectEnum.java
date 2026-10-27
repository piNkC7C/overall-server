package cn.iocoder.yudao.module.fms.enums.closing;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FMS 预置结转科目编码枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsClosingPresetSubjectEnum {

    PRIOR_YEAR_ADJUSTMENT("6000", "Prior-year P&L adjustment"),
    PRIOR_YEAR_ADJUSTMENT_CLOSING("310415", "Retained earnings"),
    CURRENT_YEAR_PROFIT("3103", "Current-year profit"),

    UNPAID_VAT("22210104", "Output unpaid VAT"),
    OUTPUT_VAT("222102", "Output VAT"),
    VAT_PAYABLE("222101", "VAT payable"),
    CONSUMPTION_TAX("222121", "Consumption tax payable"),

    EDUCATION_SURCHARGE("540310", "Education surcharge"),
    EDUCATION_SURCHARGE_PAYABLE("222113", "Education surcharge payable"),
    CITY_MAINTENANCE_TAX("540303", "Urban construction tax"),
    CITY_MAINTENANCE_TAX_PAYABLE("222117", "Urban construction tax payable"),
    LOCAL_EDUCATION_SURCHARGE("540313", "Local education surcharge"),
    LOCAL_EDUCATION_SURCHARGE_PAYABLE("222114", "Local education surcharge payable"),

    INCOME_TAX_EXPENSE("5801", "Income-tax expense"),
    INCOME_TAX_PAYABLE("222111", "Income tax payable");

    /**
     * 科目编码
     */
    private final String code;
    /**
     * 科目名称
     */
    private final String name;
}
