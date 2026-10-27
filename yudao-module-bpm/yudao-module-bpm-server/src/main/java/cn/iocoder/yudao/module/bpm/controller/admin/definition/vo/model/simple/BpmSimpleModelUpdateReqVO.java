package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model.simple;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// TODO @jason：需要考虑，如果某个节点的配置不正确，需要有提示；具体怎么实现，可以讨论下；
@Schema(description = "Create or update simple workflow design model request VO.")
@Data
public class BpmSimpleModelUpdateReqVO {

    @Schema(description = "Workflow model code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "Workflow model code is required.")
    private String id; // 对应 Flowable act_re_model 表 ID_ 字段

    @Schema(description = "Simple workflow model.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Simple workflow model cannot be empty.")
    @Valid
    private BpmSimpleModelNodeVO simpleModel;

}
