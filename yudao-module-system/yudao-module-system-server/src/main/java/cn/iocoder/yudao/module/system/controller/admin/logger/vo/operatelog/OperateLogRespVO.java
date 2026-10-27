package cn.iocoder.yudao.module.system.controller.admin.logger.vo.operatelog;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;
import org.dromara.core.trans.anno.Trans;
import org.dromara.core.trans.constant.TransType;
import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - Activity Log response.")
@Data
@ExcelIgnoreUnannotated
public class OperateLogRespVO implements VO {

    @Schema(description = "Log ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Log ID")
    private Long id;

    @Schema(description = "Trace ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "89aca178-a370-411c-ae02-3f0d672be4ab")
    private String traceId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @Trans(type = TransType.SIMPLE, target = AdminUserDO.class, fields = "nickname", ref = "userName")
    private Long userId;
    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Operator")
    private String userName;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1", implementation = Integer.class)
    @ExcelProperty("User Type")
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    @Schema(description = "Module type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order.")
    @ExcelProperty("Module Type")
    private String type;

    @Schema(description = "Action name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Createorder.")
    @ExcelProperty("Action Name")
    private String subType;

    @Schema(description = "Module business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Module Business ID")
    private Long bizId;

    @Schema(description = "Actiondetail.", example = "Update user 1: change gender from male to female, and name from John to Jane.")
    private String action;

    @Schema(description = "Extra JSON", example = "{'orderId': 1}")
    private String extra;

    @Schema(description = "Request method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "GET")
    @NotEmpty(message = "Request method is required.")
    private String requestMethod;

    @Schema(description = "Request URL.", requiredMode = Schema.RequiredMode.REQUIRED, example = "/xxx/yyy")
    private String requestUrl;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

    @Schema(description = "Browser user agent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Mozilla/5.0")
    private String userAgent;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
