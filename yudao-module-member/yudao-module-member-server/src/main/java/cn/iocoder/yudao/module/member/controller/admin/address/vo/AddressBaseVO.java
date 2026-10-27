package cn.iocoder.yudao.module.member.controller.admin.address.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import jakarta.validation.constraints.*;

/**
 * 用户收件地址 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class AddressBaseVO {

    @Schema(description = "Recipient name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotNull(message = "Recipient name is required.")
    private String name;

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "Region code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15716")
    @NotNull(message = "Region code cannot be empty.")
    private Long areaId;

    @Schema(description = "Detailed shipping address.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Detailed shipping address cannot be empty.")
    private String detailAddress;

    @Schema(description = "Is not default.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Is not default is required.")
    private Boolean defaultStatus;

}
