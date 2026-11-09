package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.send;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 公文发文 Response VO")
@Data
public class OaOfficialDocSendRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "套红模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long templateId;

    @Schema(description = "公文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "字号", example = "OA")
    private String noPrefix;

    @Schema(description = "年份", example = "2026")
    private Integer year;

    @Schema(description = "第几号文", example = "1")
    private Integer sequence;

    @Schema(description = "密级", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer secrecyLevel;

    @Schema(description = "紧急程度", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer urgencyLevel;

    @Schema(description = "公开类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer disclosureType;

    @Schema(description = "发文日期", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime issueTime;

    @Schema(description = "发文部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long sendDeptId;

    @Schema(description = "主送部门编号列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    private List<Long> mainDeptIds;

    @Schema(description = "抄送部门编号列表", example = "[1, 2]")
    private List<Long> copyDeptIds;

    @Schema(description = "公文正文", example = "Please finish the office-supply count and submit results by Friday.")
    private String content;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "正式公文地址", example = "https://example.com/file.pdf")
    private String formalFileUrl;

    @Schema(description = "附注", example = "Please handle this as requested and report back")
    private String remark;

    @Schema(description = "单据编号", example = "CC202609140001")
    private String no;

    @Schema(description = "公文文号", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "签发人编号", example = "1024")
    private Long signerUserId;

    @Schema(description = "签发人", example = "John.")
    private String signerName;

    @Schema(description = "发文部门", example = "Administration.")
    private String sendDeptName;

    @Schema(description = "主送部门", example = "[\"Administration\"]")
    private List<String> mainDeptNames;

    @Schema(description = "抄送部门", example = "[\"Finance\"]")
    private List<String> copyDeptNames;

    @Schema(description = "审批状态", example = "-1")
    private Integer status;

    @Schema(description = "流程实例编号", example = "1024")
    private String processInstanceId;

    @Schema(description = "创建人编号", example = "1024")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
