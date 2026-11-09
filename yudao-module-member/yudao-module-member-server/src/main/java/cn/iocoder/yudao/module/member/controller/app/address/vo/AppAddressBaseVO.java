package cn.iocoder.yudao.module.member.controller.app.address.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

// TODO 芋艿：example 缺失
/**
* 用户收件地址 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppAddressBaseVO {

    @Schema(description = "收件人名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Recipient name is required.")
    private String name;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "地区编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Region ID is required.")
    private Long areaId;

    @Schema(description = "收件详细地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Detailed shipping address cannot be empty.")
    private String detailAddress;

    @Schema(description = "是否默认地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not default Address is required.")
    private Boolean defaultStatus;

}
