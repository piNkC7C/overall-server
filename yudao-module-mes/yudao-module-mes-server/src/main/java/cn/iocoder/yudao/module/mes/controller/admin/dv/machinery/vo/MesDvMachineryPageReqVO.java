package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Schema(description = "MES device ledger page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvMachineryPageReqVO extends PageParam {

    @Schema(description = "Device code.", example = "EQ-001")
    private String code;

    @Schema(description = "Device name.", example = "CNC center")
    private String name;

    @Schema(description = "Brand.", example = "Siemens")
    private String brand;

    @Schema(description = "Device type code.", example = "100")
    private Long machineryTypeId;

    @Schema(description = "Device type IDs, including subtypes. Filled by the server.", hidden = true)
    private Set<Long> machineryTypeIds;

    @Schema(description = "Workshop code.", example = "200")
    private Long workshopId;

    @Schema(description = "Device status.", example = "1")
    private Integer status;

}
