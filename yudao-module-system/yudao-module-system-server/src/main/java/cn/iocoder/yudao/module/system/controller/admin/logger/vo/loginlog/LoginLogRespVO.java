package cn.iocoder.yudao.module.system.controller.admin.logger.vo.loginlog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Sign-in log response VO.")
@Data
@ExcelIgnoreUnannotated
public class LoginLogRespVO {

    @Schema(description = "Log ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Log ID")
    private Long id;

    @Schema(description = "Log type, see LoginLogTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Log Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_TYPE)
    private Integer logType;

    @Schema(description = "User ID.", example = "666")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "Trace ID.", example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "Username.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @ExcelProperty("Username")
    private String username;

    @Schema(description = "Sign-in result, see LoginResultEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Sign-in Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_RESULT)
    private Integer result;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    @ExcelProperty("Login IP")
    private String userIp;

    @Schema(description = "Browser user agent.", example = "Mozilla/5.0")
    @ExcelProperty("User Agent")
    private String userAgent;

    @Schema(description = "Sign-in time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Login Time")
    private LocalDateTime createTime;

}
