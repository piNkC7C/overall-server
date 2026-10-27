package cn.iocoder.yudao.module.member.controller.admin.point.vo.recrod;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - user points record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberPointRecordPageReqVO extends PageParam {

    @Schema(description = "Nickname", example = "John.")
    private String nickname;

    @Schema(description = "User ID.", example = "123")
    private Long userId;

    @Schema(description = "Business type.", example = "1")
    private Integer bizType;

    @Schema(description = "Points title.", example = "Heh")
    private String title;

}
