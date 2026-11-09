package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.record;

import cn.iocoder.yudao.module.mes.enums.pro.MesProAndonStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 安灯呼叫记录更新 Request VO")
@Data
public class MesProAndonRecordUpdateReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "处置时间")
    private LocalDateTime handleTime;

    @Schema(description = "处置人编号", example = "100")
    private Long handlerUserId;

    @Schema(description = "备注", example = "Fixed")
    private String remark;

    @Schema(description = "处置状态", example = "1")
    @NotNull(message = "Handle status is required.")
    private Integer status;

    @AssertTrue(message = "Handled time is required when marking as handled.")
    @JsonIgnore
    public boolean isHandleTimeValid() {
        if (!MesProAndonStatusEnum.HANDLED.getStatus().equals(status)) {
            return true;
        }
        return handleTime != null;
    }

    @AssertTrue(message = "Handler is required when marking as handled.")
    @JsonIgnore
    public boolean isHandlerUserIdValid() {
        if (!MesProAndonStatusEnum.HANDLED.getStatus().equals(status)) {
            return true;
        }
        return handlerUserId != null;
    }

}
