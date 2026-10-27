package cn.iocoder.yudao.module.oa.controller.admin.seal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - Seal response.")
@Data
public class OaSealRespVO {

    @Schema(description = "Code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Department code.", example = "103", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long deptId;

    @Schema(description = "Department.", example = "R&D")
    private String deptName;

    @Schema(description = "Seal No.", example = "SEAL-001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "Seal Name", example = "Company seal", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Seal Type", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;

    @Schema(description = "Sealcategory.", example = "1")
    private Integer category;

    @Schema(description = "Custodian user ID.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long keeperUserId;

    @Schema(description = "Custodian Dept code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long keeperDeptId;

    @Schema(description = "Custodian.", example = "Overall.")
    private String keeperName;

    @Schema(description = "Custodian Dept", example = "R&D")
    private String keeperDeptName;

    @Schema(description = "Seal ledger status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Purchase Time", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime purchaseTime;

    @Schema(description = "Enabled time.", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime enableTime;

    @Schema(description = "Disable time.", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime disableTime;

    @Schema(description = "Seal image URL.", example = "https://example.com/seal.png")
    private String picUrl;

    @Schema(description = "Sort", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;

    @Schema(description = "Notes.", example = "Archive after the contract is signed")
    private String remark;

    @Schema(description = "Create time.", example = "1789088400000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime createTime;

}
