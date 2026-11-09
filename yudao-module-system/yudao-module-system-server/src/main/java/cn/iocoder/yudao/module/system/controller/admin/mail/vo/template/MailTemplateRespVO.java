package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 邮件末班 Response VO")
@Data
public class MailTemplateRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "模版名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test name")
    private String name;

    @Schema(description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    private String code;

    @Schema(description = "发送的邮箱账号编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountId;

    @Schema(description = "发送人名称", example = "Taro")
    private String nickname;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Register succeeded.")
    private String title;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, you signed up successfully")
    private String content;

    @Schema(description = "参数数组", example = "name,code")
    private List<String> params;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "备注", example = "Ultraman")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
