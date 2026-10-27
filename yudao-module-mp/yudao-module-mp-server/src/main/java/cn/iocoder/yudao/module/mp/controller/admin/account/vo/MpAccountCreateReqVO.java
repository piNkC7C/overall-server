package cn.iocoder.yudao.module.mp.controller.admin.account.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Official Account account create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpAccountCreateReqVO extends MpAccountBaseVO {

}
