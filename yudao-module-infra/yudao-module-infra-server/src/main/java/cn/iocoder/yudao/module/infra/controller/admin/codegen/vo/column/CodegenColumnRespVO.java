package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.column;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Codegen column definition response VO.")
@Data
public class CodegenColumnRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Table ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long tableId;

    @Schema(description = "Field name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user_age")
    private String columnName;

    @Schema(description = "Field type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "int(11)")
    private String dataType;

    @Schema(description = "FieldDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Age")
    private String columnComment;

    @Schema(description = "Is not allow is empty.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean nullable;

    @Schema(description = "Is not primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean primaryKey;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer ordinalPosition;

    @Schema(description = "Java attribute type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "userAge")
    private String javaType;

    @Schema(description = "Java field name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Integer")
    private String javaField;

    @Schema(description = "Dictionary type.", example = "sys_gender")
    private String dictType;

    @Schema(description = "Data sample.", example = "1024")
    private String example;

    @Schema(description = "Is not is Create createaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean createOperation;

    @Schema(description = "Is not is Update updateaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean updateOperation;

    @Schema(description = "Is not is List searchaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean listOperation;

    @Schema(description = "List searchaction condition type, see CodegenColumnListConditionEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "LIKE")
    private String listOperationCondition;

    @Schema(description = "Returned by list query", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean listOperationResult;

    @Schema(description = "Show type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "input")
    private String htmlType;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
