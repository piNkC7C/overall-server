package cn.iocoder.yudao.module.promotion.controller.admin.reward.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - spend-and-save campaigncreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RewardActivityCreateReqVO extends RewardActivityBaseVO {

}
