package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - PMS work item board request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsWorkItemBoardReqVO extends PmsWorkItemPageReqVO {

    @Override
    @NotNull(message = "Work item type is required.")
    public Integer getType() {
        return super.getType();
    }

}
