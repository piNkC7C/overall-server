package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * MES 装箱单分页 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES packing order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmPackagePageReqVO extends PageParam {

    @Schema(description = "Packing order code.", example = "PKG")
    private String code;

    @Schema(description = "Sales order code.", example = "SO")
    private String salesOrderCode;

    @Schema(description = "Customer ID.", example = "1")
    private Long clientId;

    @Schema(description = "Parent box ID.", example = "1024")
    private Long parentId;

    @Schema(description = "Inspector user ID.", example = "1")
    private Long inspectorUserId;

    @Schema(description = "Document status.", example = "1")
    private Integer status;

}
