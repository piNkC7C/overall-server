package cn.iocoder.yudao.module.bpm.enums.definition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * BPM 条件表达式操作符枚举
 *
 * @author Lesan
 */
@RequiredArgsConstructor
@Getter
public enum BpmConditionOpCodeEnum {

    EQ("==", "Equals", " var:getOrDefault(%s, null) == %s "),
    NE("!=", "Not equals", " var:getOrDefault(%s, null) != %s "),
    GT(">", "Greater than", " var:getOrDefault(%s, null) > %s "),
    GE(">=", "Greater than or equal", " var:getOrDefault(%s, null) >= %s "),
    LT("<", "Less than", " var:getOrDefault(%s, null) < %s "),
    LE("<=", "Less than or equal", " var:getOrDefault(%s, null) <= %s "),

    CONTAINS("contain", "Include.", " var:contains(%s, %s) "),
    NOT_CONTAINS("!contain", "Not include.", " !var:contains(%s, %s) ");

    private final String code;
    private final String des;
    private final String symbol;

    public static BpmConditionOpCodeEnum fromCode(String code) {
        for (BpmConditionOpCodeEnum op : BpmConditionOpCodeEnum.values()) {
            if (op.code.equalsIgnoreCase(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("UnknownOperator." + code);
    }

}
