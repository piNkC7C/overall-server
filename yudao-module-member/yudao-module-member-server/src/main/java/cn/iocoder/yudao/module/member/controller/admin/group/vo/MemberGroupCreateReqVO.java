package cn.iocoder.yudao.module.member.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - user groupcreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberGroupCreateReqVO extends MemberGroupBaseVO {

}
