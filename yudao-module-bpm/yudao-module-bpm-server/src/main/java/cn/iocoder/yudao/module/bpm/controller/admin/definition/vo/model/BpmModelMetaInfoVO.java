package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple.BpmSimpleModelNodeVO;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmAutoApproveTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmModelFormTypeEnum;
import cn.iocoder.yudao.module.bpm.enums.definition.BpmModelTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * BPM 流程 MetaInfo Response DTO
 * 主要用于 { Model#setMetaInfo(String)} 的存储
 *
 * 最终，它的字段和
 * {@link cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmProcessDefinitionInfoDO}
 * 是一致的
 *
 * @author 芋道源码
 */
@Data
public class BpmModelMetaInfoVO {

    @Schema(description = "Workflow icon.", example = "https://www.iocoder.cn/yudao.jpg")
    @URL(message = "Workflow icon format is invalid.")
    private String icon;

    @Schema(description = "WorkflowDescription.", example = "Me is Description.")
    private String description;

    @Schema(description = "Workflow type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @InEnum(BpmModelTypeEnum.class)
    @NotNull(message = "Workflow type is required.")
    private Integer type;

    @Schema(description = "Form type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @InEnum(BpmModelFormTypeEnum.class)
    @NotNull(message = "Form type is required.")
    private Integer formType;
    @Schema(description = "Form code.", example = "1024")
    private Long formId; // FormType is NORMAL used, must not Empty

    @Schema(description = "Custom form submit path. Use a Vue route.", example = "/bpm/oa/leave/create")
    private String formCustomCreatePath; // Form type is CUSTOM time, must not Empty
    @Schema(description = "Custom form view path. Use a Vue route.", example = "/bpm/oa/leave/view")
    private String formCustomViewPath; // Form type is CUSTOM time, must not Empty

    @Schema(description = "Visible", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Visible is required.")
    private Boolean visible;

    @Schema(description = "Can startuser ID list.", example = "[1,2,3]")
    private List<Long> startUserIds;

    @Schema(description = "Can startdepartment ID list.", example = "[2,4,6]")
    private List<Long> startDeptIds;

    @Schema(description = "Can admin user ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2,4,6]")
    @NotEmpty(message = "Can admin user ID list is required.")
    private List<Long> managerUserIds;

    @Schema(description = "Sort.", example = "1")
    private Long sort; // 创建时，后端自动生成

    @Schema(description = "Allow canceling in-approval requests.", example = "true")
    private Boolean allowCancelRunningProcess;

    @Schema(description = "Allow allow approverwithdrawtask.", example = "false")
    private Boolean allowWithdrawTask;

    @Schema(description = "Workflow ID rule.", example = "{}")
    private ProcessIdRule processIdRule;

    @Schema(description = "Auto-dedupe type.", example = "1")
    @InEnum(BpmAutoApproveTypeEnum.class)
    private Integer autoApprovalType;

    @Schema(description = "Titleset.", example = "{}")
    private TitleSetting titleSetting;

    @Schema(description = "Summaryset.", example = "{}")
    private SummarySetting summarySetting;

    @Schema(description = "Workflow pre-notice setting.", example = "{}")
    private HttpRequestSetting processBeforeTriggerSetting;

    @Schema(description = "Workflow post-notice setting.", example = "{}")
    private HttpRequestSetting processAfterTriggerSetting;

    @Schema(description = "Task pre-notice setting.", example = "{}")
    private HttpRequestSetting taskBeforeTriggerSetting;

    @Schema(description = "Task post-notice setting.", example = "{}")
    private HttpRequestSetting taskAfterTriggerSetting;

    @Schema(description = "Custom print-template setting.", example = "{}")
    @Valid
    private PrintTemplateSetting printTemplateSetting;

    @Schema(description = "Workflow ID rule.")
    @Data
    @Valid
    public static class ProcessIdRule {

        @Schema(description = "Is not Enabled.", example = "false")
        @NotNull(message = "Is not Enabled is required.")
        private Boolean enable;

        @Schema(description = "Prefix.", example = "XX")
        private String prefix;

        @Schema(description = "Infix.", example = "20250120")
        private String infix; // 精确到日、精确到时、精确到分、精确到秒

        @Schema(description = "Suffix.", example = "YY")
        private String postfix;

        @Schema(description = "Sequence length.", example = "5")
        @NotNull(message = "Sequence length cannot be empty.")
        private Integer length;

    }

    @Schema(description = "Titleset.")
    @Data
    @Valid
    public static class TitleSetting {

        @Schema(description = "Is not Custom.", example = "false")
        @NotNull(message = "Is not Custom is required.")
        private Boolean enable;

        @Schema(description = "Title.", example = "Workflow title.")
        private String title;

    }

    @Schema(description = "Summaryset.")
    @Data
    @Valid
    public static class SummarySetting {

        @Schema(description = "Is not Custom.", example = "false")
        @NotNull(message = "Is not Custom is required.")
        private Boolean enable;

        @Schema(description = "SummaryfieldArray.", example = "[]")
        private List<String> summary;

    }

    @Schema(description = "HTTP notice setting.", example = "{}")
    @Data
    public static class HttpRequestSetting {

        @Schema(description = "Request path.", example = "http://127.0.0.1")
        @NotEmpty(message = "Request URL cannot be empty.")
        @URL(message = "Request URL format is invalid.")
        private String url;

        @Schema(description = "Request Header parameter set.", example = "[]")
        @Valid
        private List<BpmSimpleModelNodeVO.HttpRequestParam> header;

        @Schema(description = "Request Header parameter set.", example = "[]")
        @Valid
        private List<BpmSimpleModelNodeVO.HttpRequestParam> body;

        /**
         * 请求返回处理设置，用于修改流程表单值
         * <p>
         * key：表示要修改的流程表单字段名(name)
         * value：接口返回的字段名
         */
        @Schema(description = "Response-handling setting.", example = "[]")
        private List<KeyValue<String, String>> response;

    }

    @Schema(description = "Custom print-template setting.")
    @Data
    public static class PrintTemplateSetting {

        @Schema(description = "Use a custom print template.", example = "false")
        @NotNull(message = "Use a custom print template cannot be empty.")
        private Boolean enable;

        @Schema(description = "Print template.", example = "<p></p>")
        private String template;

    }

}
