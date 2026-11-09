package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

/**
 * 会员用户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberUserBaseVO {

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotNull(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Status is required.")
    private Byte status;

    @Schema(description = "邮箱", example = "member@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Nickname is required.")
    private String nickname;

    @Schema(description = "头像", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/x.png")
    @URL(message = "Avatar must be URL format.")
    private String avatar;

    @Schema(description = "用户昵称", example = "Jane.")
    private String name;

    @Schema(description = "用户性别", example = "1")
    private Integer sex;

    @Schema(description = "所在地编号", example = "4371")
    private Long areaId;

    @Schema(description = "所在地全程", example = "Putuo District, Shanghai")
    private String areaName;

    @Schema(description = "出生日期", example = "2023-03-12")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDateTime birthday;

    @Schema(description = "会员备注", example = "I am a short note")
    private String mark;

    @Schema(description = "会员标签", example = "[1, 2]")
    private List<Long> tagIds;

    @Schema(description = "会员等级编号", example = "1")
    private Long levelId;

    @Schema(description = "用户分组编号", example = "1")
    private Long groupId;

}
