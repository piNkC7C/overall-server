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

    @Schema(description = "Phone number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300")
    @NotNull(message = "Phone number is required.")
    private String mobile;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Status is required.")
    private Byte status;

    @Schema(description = "Email", example = "member@iocoder.cn")
    @Email(message = "Email format is invalid.")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Nickname is required.")
    private String nickname;

    @Schema(description = "Avatar", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/x.png")
    @URL(message = "Avatar must be URL format.")
    private String avatar;

    @Schema(description = "Nickname", example = "Jane.")
    private String name;

    @Schema(description = "UserGender.", example = "1")
    private Integer sex;

    @Schema(description = "Location code.", example = "4371")
    private Long areaId;

    @Schema(description = "Full location.", example = "Putuo District, Shanghai")
    private String areaName;

    @Schema(description = "Date of birth", example = "2023-03-12")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDateTime birthday;

    @Schema(description = "Member notes.", example = "I am a short note")
    private String mark;

    @Schema(description = "Membertag.", example = "[1, 2]")
    private List<Long> tagIds;

    @Schema(description = "Member level code.", example = "1")
    private Long levelId;

    @Schema(description = "User group code.", example = "1")
    private Long groupId;

}
