package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.column;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Codegen column create or update request VO.")
@Data
public class CodegenColumnSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Table ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Table ID is required.")
    private Long tableId;

    @Schema(description = "Field name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user_age")
    @NotNull(message = "Field name is required.")
    private String columnName;

    @Schema(description = "Field type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "int(11)")
    @NotNull(message = "Field type is required.")
    private String dataType;

    @Schema(description = "FieldDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Age")
    @NotNull(message = "FieldDescription is required.")
    private String columnComment;

    @Schema(description = "Is not allow is empty.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not allow is empty is required.")
    private Boolean nullable;

    @Schema(description = "Is not primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not primary key is required.")
    private Boolean primaryKey;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer ordinalPosition;

    @Schema(description = "Java attribute type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "userAge")
    @NotNull(message = "Java attribute type is required.")
    private String javaType;

    @Schema(description = "Java field name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Integer")
    @NotNull(message = "Java field name is required.")
    private String javaField;

    @Schema(description = "Dictionary type.", example = "sys_gender")
    private String dictType;

    @Schema(description = "Data sample.", example = "1024")
    private String example;

    @Schema(description = "Is not is Create createaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not is Create createaction field is required.")
    private Boolean createOperation;

    @Schema(description = "Is not is Update updateaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not is Update updateaction field is required.")
    private Boolean updateOperation;

    @Schema(description = "Is not is List searchaction field.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not is List searchaction field is required.")
    private Boolean listOperation;

    @Schema(description = "List searchaction condition type, see CodegenColumnListConditionEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "LIKE")
    @NotNull(message = "List searchaction condition type is required.")
    private String listOperationCondition;

    @Schema(description = "Returned by list query", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Returned by list query is required.")
    private Boolean listOperationResult;

    @Schema(description = "Show type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "input")
    @NotNull(message = "Show type is required.")
    private String htmlType;

}
