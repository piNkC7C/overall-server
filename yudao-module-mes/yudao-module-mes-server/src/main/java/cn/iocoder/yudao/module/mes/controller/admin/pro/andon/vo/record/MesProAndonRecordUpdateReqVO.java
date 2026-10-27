package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.record;

import cn.iocoder.yudao.module.mes.enums.pro.MesProAndonStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "MES andon call record update request VO.")
@Data
public class MesProAndonRecordUpdateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Handle time.")
    private LocalDateTime handleTime;

    @Schema(description = "Handle person code.", example = "100")
    private Long handlerUserId;

    @Schema(description = "Notes.", example = "Fixed")
    private String remark;

    @Schema(description = "Handle status.", example = "1")
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
