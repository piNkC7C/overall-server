package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.contact;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 员工联系人保存 Request VO")
@Data
public class HrmEmployeeContactSaveReqVO {

    @Schema(description = "联系人编号", example = "1024")
    private Long id;

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "联系人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotBlank(message = "Contact name is required.")
    @Size(max = 64, message = "Contact name length cannot exceed 64 characters.")
    @DiffLogField(name = "联系人名称")
    private String name;

    @Schema(description = "关系", example = "Spouse")
    @Size(max = 64, message = "Relationship length cannot exceed 64 characters.")
    @DiffLogField(name = "关系")
    private String relation;

    @Schema(description = "联系人电话", example = "15601691301")
    @Size(max = 40, message = "ContactPhone length cannot exceed 40 characters.")
    @DiffLogField(name = "联系人电话")
    private String phone;

    @Schema(description = "联系人工作单位", example = "Sample Tech")
    @Size(max = 128, message = "Contact employer length cannot exceed 128 characters.")
    @DiffLogField(name = "联系人工作单位")
    private String workUnit;

    @Schema(description = "联系人职务", example = "Product manager")
    @Size(max = 128, message = "ContactTitle length cannot exceed 128 characters.")
    @DiffLogField(name = "联系人职务")
    private String postName;

    @Schema(description = "联系人地址", example = "Xihu District, Hangzhou")
    @Size(max = 255, message = "ContactAddress length cannot exceed 255 characters.")
    @DiffLogField(name = "联系人地址")
    private String address;

    @Schema(description = "排序", example = "1")
    @DiffLogField(name = "排序")
    private Integer sort;

}
