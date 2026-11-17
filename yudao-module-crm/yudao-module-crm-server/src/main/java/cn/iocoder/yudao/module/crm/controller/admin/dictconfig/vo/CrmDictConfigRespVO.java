package cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - CRM 字典枚举配置 Response VO")
@Data
public class CrmDictConfigRespVO {

    @Schema(description = "字典数据编号", example = "1474")
    private Long id;

    @Schema(description = "显示顺序", example = "1")
    private Integer sort;

    @Schema(description = "字典标签", example = "打电话")
    private String label;

    @Schema(description = "字典键值", example = "1")
    private String value;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "颜色类型", example = "default")
    private String colorType;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "是否已被业务数据使用", example = "true")
    private Boolean inUse;

    @Schema(description = "是否系统内置（外部线索收集）", example = "false")
    private Boolean systemBuiltin;

}
