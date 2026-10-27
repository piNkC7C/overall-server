package cn.iocoder.yudao.framework.common.biz.infra.logger.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * API 访问日志
 *
 * @author 芋道源码
 */
@Data
public class ApiAccessLogCreateReqDTO {

    /**
     * 链路追踪编号
     */
    private String traceId;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 应用名
     */
    @NotNull(message = "App name is required.")
    private String applicationName;

    /**
     * 请求方法名
     */
    @NotNull(message = "Http Request Method is required.")
    private String requestMethod;
    /**
     * 访问地址
     */
    @NotNull(message = "Access Address is required.")
    private String requestUrl;
    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 响应结果
     */
    private String responseBody;
    /**
     * 用户 IP
     */
    @NotNull(message = "Ip is required.")
    private String userIp;
    /**
     * 浏览器 UA
     */
    @NotNull(message = "User-Agent is required.")
    private String userAgent;

    /**
     * 操作模块
     */
    private String operateModule;
    /**
     * 操作名
     */
    private String operateName;
    /**
     * 操作分类
     *
     * 枚举，参见 OperateTypeEnum 类
     */
    private Integer operateType;

    /**
     * 开始请求时间
     */
    @NotNull(message = "Request start time is required.")
    private LocalDateTime beginTime;
    /**
     * 结束请求时间
     */
    @NotNull(message = "Request end time is required.")
    private LocalDateTime endTime;
    /**
     * 执行时长，单位：毫秒
     */
    @NotNull(message = "Duration is required.")
    private Integer duration;
    /**
     * 结果码
     */
    @NotNull(message = "Error code cannot be empty.")
    private Integer resultCode;
    /**
     * 结果提示
     */
    private String resultMsg;

}
