package cn.iocoder.yudao.module.oa.controller.admin.reimbursement.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Expense report page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaReimbursementPageReqVO extends PageParam {

    @Schema(description = "Title.", example = "Customer-project travel reimbursement")
    private String title;

    @Schema(description = "Approval status.", example = "-1")
    private Integer status;

}
