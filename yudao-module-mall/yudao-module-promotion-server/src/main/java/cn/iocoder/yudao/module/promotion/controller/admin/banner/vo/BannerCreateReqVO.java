package cn.iocoder.yudao.module.promotion.controller.admin.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xia
 */
@Schema(description = "Admin - Banner create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BannerCreateReqVO extends BannerBaseVO {

}
