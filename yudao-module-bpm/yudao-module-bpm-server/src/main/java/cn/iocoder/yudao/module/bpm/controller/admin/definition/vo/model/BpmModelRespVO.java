package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model;

import cn.iocoder.yudao.module.bpm.controller.admin.base.dept.DeptSimpleBaseVO;
import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple.BpmSimpleModelNodeVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.process.BpmProcessDefinitionRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - workflow model response.")
@Data
public class BpmModelRespVO extends BpmModelMetaInfoVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String id;

    @Schema(description = "Workflow key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "process_yudao")
    private String key;

    @Schema(description = "Workflow name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Workflow icon.", example = "https://www.iocoder.cn/yudao.jpg")
    private String icon;

    @Schema(description = "Workflowcategory code.", example = "1")
    private String category;
    @Schema(description = "Workflowcategory name.", example = "Leave")
    private String categoryName;

    @Schema(description = "Form name.", example = "Leave form")
    private String formName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Can start userArray.")
    private List<UserSimpleBaseVO> startUsers;

    @Schema(description = "Can start departmentArray.")
    private List<DeptSimpleBaseVO> startDepts;

    @Schema(description = "BPMN XML")
    private String bpmnXml;

    @Schema(description = "Simple workflow model.")
    private BpmSimpleModelNodeVO simpleModel;

    /**
     * 最新部署的流程定义
     */
    private BpmProcessDefinitionRespVO processDefinition;

}
