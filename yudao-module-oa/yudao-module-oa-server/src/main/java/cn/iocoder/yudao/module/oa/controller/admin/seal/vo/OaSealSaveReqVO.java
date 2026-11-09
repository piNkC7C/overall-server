package cn.iocoder.yudao.module.oa.controller.admin.seal.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.seal.OaSealStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 印章新增/修改 Request VO")
@Data
public class OaSealSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "所属部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "103")
    @NotNull(message = "Department is required.")
    private Long deptId;

    @Schema(description = "印章名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company seal")
    @NotBlank(message = "Seal Name is required.")
    @Size(max = 128, message = "Seal Name length cannot exceed 128 characters.")
    private String name;

    @Schema(description = "印章类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Seal Type is required.")
    private Integer type;

    @Schema(description = "印章分类", example = "1")
    private Integer category;

    @Schema(description = "保管人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Custodian user ID is required.")
    private Long keeperUserId;

    @Schema(description = "保管部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Custodian Dept code is required.")
    private Long keeperDeptId;

    @Schema(description = "印章状态", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Seal status is required.")
    @InEnum(value = OaSealStatusEnum.class, message = "Seal status must be {value}.")
    private Integer status;

    @Schema(description = "购买时间", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime purchaseTime;

    @Schema(description = "启用时间", example = "1789088400000", type = "integer", format = "int64")
    private LocalDateTime enableTime;

    @Schema(description = "停用时间", example = "1789174800000", type = "integer", format = "int64")
    private LocalDateTime disableTime;

    @Schema(description = "印章照片地址", example = "https://example.com/seal.png")
    @Size(max = 2048, message = "Seal image URL cannot exceed 2048 characters.")
    private String picUrl;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "备注", example = "Archive after the contract is signed")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
