package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.normal.vo;

import cn.iocoder.yudao.module.infra.dal.dataobject.demo.demo03.Demo03CourseDO;
import cn.iocoder.yudao.module.infra.dal.dataobject.demo.demo03.Demo03GradeDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - studentcreate/update request.")
@Data
public class Demo03StudentNormalSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8525")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Gender is required.")
    private Integer sex;

    @Schema(description = "Date of birth", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date of birth is required.")
    private LocalDateTime birthday;

    @Schema(description = "Bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample.")
    @NotEmpty(message = "Bio is required.")
    private String description;

    @Schema(description = "Student course list.")
    private List<Demo03CourseDO> demo03Courses;

    @Schema(description = "Student class.")
    private Demo03GradeDO demo03Grade;

}