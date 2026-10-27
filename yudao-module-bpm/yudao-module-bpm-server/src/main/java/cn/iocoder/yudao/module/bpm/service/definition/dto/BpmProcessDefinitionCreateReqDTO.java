package cn.iocoder.yudao.module.bpm.service.definition.dto;

import cn.iocoder.yudao.module.bpm.enums.definition.BpmModelFormTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 流程定义创建 Request DTO
 */
@Data
public class BpmProcessDefinitionCreateReqDTO {

    // ========== 模型相关 ==========

    /**
     * 流程模型的编号
     */
    @NotEmpty(message = "Workflow model code is required.")
    private String modelId;
    /**
     * 流程标识
     */
    @NotEmpty(message = "Workflow key is required.")
    private String key;
    /**
     * 流程名称
     */
    @NotEmpty(message = "Workflow name is required.")
    private String name;
    /**
     * 流程描述
     */
    private String description;
    /**
     * 流程分类
     */
    @NotEmpty(message = "Workflowcategory is required.")
    private String category;
    /**
     * BPMN XML
     */
    @NotEmpty(message = "BPMN XML is required.")
    private byte[] bpmnBytes;

    // ========== 表单相关 ==========

    /**
     * 表单类型
     */
    @NotNull(message = "Form type is required.")
    private Integer formType;
    /**
     * 动态表单编号
     * 在表单类型为 {@link BpmModelFormTypeEnum#NORMAL} 时
     */
    private Long formId;
    /**
     * 表单的配置
     * 在表单类型为 {@link BpmModelFormTypeEnum#NORMAL} 时
     */
    private String formConf;
    /**
     * 表单项的数组
     * 在表单类型为 {@link BpmModelFormTypeEnum#NORMAL} 时
     */
    private List<String> formFields;
    /**
     * 自定义表单的提交路径，使用 Vue 的路由地址
     * 在表单类型为 {@link BpmModelFormTypeEnum#CUSTOM} 时
     */
    private String formCustomCreatePath;
    /**
     * 自定义表单的查看路径，使用 Vue 的路由地址
     * 在表单类型为 {@link BpmModelFormTypeEnum#CUSTOM} 时
     */
    private String formCustomViewPath;

}
