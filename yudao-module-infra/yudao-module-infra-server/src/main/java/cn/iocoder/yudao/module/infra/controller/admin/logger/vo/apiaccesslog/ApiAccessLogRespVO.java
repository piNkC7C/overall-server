package cn.iocoder.yudao.module.infra.controller.admin.logger.vo.apiaccesslog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - API 访问日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ApiAccessLogRespVO {

    @Schema(description = "日志主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Log ID")
    private Long id;

    @Schema(description = "链路追踪编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "66600cb6-7852-11eb-9439-0242ac130002")
    @ExcelProperty("Trace ID")
    private String traceId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "用户类型，参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "应用名", requiredMode = Schema.RequiredMode.REQUIRED, example = "dashboard")
    @ExcelProperty("App Name")
    private String applicationName;

    @Schema(description = "请求方法名", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @ExcelProperty("Request Method")
    private String requestMethod;

    @Schema(description = "请求地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xxx/yyy")
    @ExcelProperty("Request URL")
    private String requestUrl;

    @Schema(description = "请求参数")
    @ExcelProperty("Request Params")
    private String requestParams;

    @Schema(description = "响应结果")
    @ExcelProperty("Response Body")
    private String responseBody;

    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @ExcelProperty("User IP")
    private String userIp;

    @Schema(description = "浏览器 UA", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @ExcelProperty("User Agent")
    private String userAgent;

    @Schema(description = "操作模块", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product module.")
    @ExcelProperty("Module")
    private String operateModule;

    @Schema(description = "操作名", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createproduct.")
    @ExcelProperty("Action Name")
    private String operateName;

    @Schema(description = "操作分类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Action Category", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.OPERATE_TYPE)
    private Integer operateType;

    @Schema(description = "开始请求时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request Start Time")
    private LocalDateTime beginTime;

    @Schema(description = "结束请求时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request End Time")
    private LocalDateTime endTime;

    @Schema(description = "执行时长", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @ExcelProperty("Duration")
    private Integer duration;

    @Schema(description = "结果码", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Result Code")
    private Integer resultCode;

    @Schema(description = "结果提示", example = "Yudao, awesome!")
    @ExcelProperty("Result Message")
    private String resultMsg;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
