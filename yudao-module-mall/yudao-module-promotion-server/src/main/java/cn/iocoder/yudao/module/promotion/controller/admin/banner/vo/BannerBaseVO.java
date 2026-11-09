package cn.iocoder.yudao.module.promotion.controller.admin.banner.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.promotion.enums.banner.BannerPositionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Banner Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 * @author xia
 */
@Data
public class BannerBaseVO {

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Title is required.")
    private String title;

    @Schema(description = "跳转链接", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Link is required.")
    private String url;

    @Schema(description = "图片地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ImageAddress is required.")
    private String picUrl;

    @Schema(description = "position", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Position is required.")
    @InEnum(BannerPositionEnum.class)
    private Integer position;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "备注")
    private String memo;

}
