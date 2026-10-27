package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

/**
* 自提门店 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DeliveryPickUpStoreBaseVO {

    @Schema(description = "Store Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotBlank(message = "Store Name is required.")
    private String name;

    @Schema(description = "Store summary.", example = "I am the store summary")
    private String introduction;

    @Schema(description = "Store Phone", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601892312")
    @NotBlank(message = "Store Phone is required.")
    @Mobile
    private String phone;

    @Schema(description = "Region code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18733")
    @NotNull(message = "Region code is required.")
    private Integer areaId;

    @Schema(description = "Store street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188 Fudan University Rd")
    @NotBlank(message = "Store street address cannot be empty.")
    private String detailAddress;

    @Schema(description = "Store Logo", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    @NotBlank(message = "Store Logo is required.")
    private String logo;

    @Schema(description = "Opening time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Opening time cannot be empty.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime openingTime;

    @Schema(description = "Closing time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Closing time cannot be empty.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime closingTime;

    @Schema(description = "Latitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "5.88")
    @NotNull(message = "Latitude is required.")
    private Double latitude;

    @Schema(description = "Longitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "6.99")
    @NotNull(message = "Longitude is required.")
    private Double longitude;

    @Schema(description = "Store Status", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Store Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
