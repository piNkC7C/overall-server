package cn.iocoder.yudao.module.member.controller.admin.signin.vo.config;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Check-in rule create request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberSignInConfigCreateReqVO extends MemberSignInConfigBaseVO {

}
