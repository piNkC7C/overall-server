package cn.iocoder.yudao.framework.algorithm.core;

import lombok.Getter;

/**
 * 调用外部算法 HTTP 失败。
 */
@Getter
public class AlgorithmHttpException extends RuntimeException {

    private final int statusCode;
    private final String detail;

    public AlgorithmHttpException(int statusCode, String detail) {
        super(detail);
        this.statusCode = statusCode;
        this.detail = detail;
    }

}
