package cn.iocoder.yudao.module.infra.controller.admin.logger.vo.apiaccesslog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "API access log response VO.")
@Data
@ExcelIgnoreUnannotated
public class ApiAccessLogRespVO {

    @Schema(description = "Log ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Log ID")
    private Long id;

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "66600cb6-7852-11eb-9439-0242ac130002")
    @ExcelProperty("Trace ID")
    private String traceId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    @ExcelProperty("User ID")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "User Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "dashboard")
    @ExcelProperty("App Name")
    private String applicationName;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @ExcelProperty("Request Method")
    private String requestMethod;

    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xxx/yyy")
    @ExcelProperty("Request URL")
    private String requestUrl;

    @Schema(description = "Request params.")
    @ExcelProperty("Request Params")
    private String requestParams;

    @Schema(description = "Response body.")
    @ExcelProperty("Response Body")
    private String responseBody;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @ExcelProperty("User IP")
    private String userIp;

    @Schema(description = "User agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    @ExcelProperty("User Agent")
    private String userAgent;

    @Schema(description = "Module.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product module.")
    @ExcelProperty("Module")
    private String operateModule;

    @Schema(description = "Action name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createproduct.")
    @ExcelProperty("Action Name")
    private String operateName;

    @Schema(description = "Actioncategory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Action Category", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.OPERATE_TYPE)
    private Integer operateType;

    @Schema(description = "Request start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request Start Time")
    private LocalDateTime beginTime;

    @Schema(description = "Request end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Request End Time")
    private LocalDateTime endTime;

    @Schema(description = "Duration.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @ExcelProperty("Duration")
    private Integer duration;

    @Schema(description = "Result code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Result Code")
    private Integer resultCode;

    @Schema(description = "ResultTip.", example = "Yudao, awesome!")
    @ExcelProperty("Result Message")
    private String resultMsg;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
