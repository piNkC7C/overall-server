package cn.iocoder.yudao.module.trade.controller.app.delivery.vo.pickup;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Schema(description = "User App - Pickup Store response.")
@Data
public class AppDeliveryPickUpStoreRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    private Long id;

    @Schema(description = "Store Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String name;

    @Schema(description = "Store Logo", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String logo;

    @Schema(description = "Store Phone", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601892312")
    private String phone;

    @Schema(description = "Region code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18733")
    private Integer areaId;

    @Schema(description = "Region name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Putuo District, Shanghai")
    private String areaName;

    @Schema(description = "Store street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188 Fudan University Rd")
    private String detailAddress;

    @Schema(description = "Opening time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Opening time cannot be empty.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime openingTime;

    @Schema(description = "Closing time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Closing time cannot be empty.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime closingTime;

    @Schema(description = "Latitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "5.88")
    private Double latitude;

    @Schema(description = "Longitude", requiredMode = Schema.RequiredMode.REQUIRED, example = "6.99")
    private Double longitude;

    @Schema(description = "Distance in kilometers.", example = "100") // 只有在用户传递了经纬度时，才进行计算
    private Double distance;

}
