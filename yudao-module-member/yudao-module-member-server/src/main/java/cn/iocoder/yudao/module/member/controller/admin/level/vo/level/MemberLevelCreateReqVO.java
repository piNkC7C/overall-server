package cn.iocoder.yudao.module.member.controller.admin.level.vo.level;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - member level create request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberLevelCreateReqVO extends MemberLevelBaseVO {

}
