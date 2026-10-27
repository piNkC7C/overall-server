package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - MES customer create / edit request.")
@Data
public class MesMdClientSaveReqVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "C00184")
    @NotEmpty(message = "Customer code is required.")
    @Size(max = 64, message = "Customer code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "BYD")
    @NotEmpty(message = "Customer name is required.")
    @Size(max = 255, message = "Customer name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Customer short name.", example = "BYD")
    @Size(max = 255, message = "Customer short name length cannot exceed 255 characters.")
    private String nickname;

    @Schema(description = "CustomerEnglish Name.", example = "BYD")
    @Size(max = 255, message = "CustomerEnglish Name length cannot exceed 255 characters.")
    private String englishName;

    @Schema(description = "Customer bio.", example = "The BYD brand started in Shenzhen")
    @Size(max = 500, message = "Customer bio length cannot exceed 500 characters.")
    private String description;

    @Schema(description = "CustomerLOGOAddress.", example = "https://xxx.com/logo.png")
    @Size(max = 255, message = "CustomerLOGOAddress length cannot exceed 255 characters.")
    private String logo;

    @Schema(description = "Customer type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer type is required.")
    private Integer type;

    @Schema(description = "CustomerAddress.", example = "Nanshan, Shenzhen")
    @Size(max = 500, message = "CustomerAddress length cannot exceed 500 characters.")
    private String address;

    @Schema(description = "Customer website.", example = "https://www.bydglobal.com")
    @Size(max = 255, message = "Customer website cannot exceed 255 characters.")
    private String website;

    @Schema(description = "CustomeremailAddress.", example = "salse@bydglobal.com")
    @Size(max = 255, message = "CustomeremailAddress length cannot exceed 255 characters.")
    @Email(message = "CustomeremailAddress format is invalid.")
    private String email;

    @Schema(description = "CustomerPhone.", example = "123432222")
    @Size(max = 64, message = "CustomerPhone length cannot exceed 64 characters.")
    private String telephone;

    @Schema(description = "Contact1.", example = "John.")
    @Size(max = 64, message = "Contact1 length cannot exceed 64 characters.")
    private String contact1Name;

    @Schema(description = "Contact1-Phone.", example = "122212312")
    @Size(max = 64, message = "Contact1-Phone length cannot exceed 64 characters.")
    private String contact1Telephone;

    @Schema(description = "Contact1-email.", example = "s1@bydglobal.com")
    @Size(max = 255, message = "Contact1-email length cannot exceed 255 characters.")
    @Email(message = "Contact1-email format is invalid.")
    private String contact1Email;

    @Schema(description = "Contact2.", example = "Jane.")
    @Size(max = 64, message = "Contact2 length cannot exceed 64 characters.")
    private String contact2Name;

    @Schema(description = "Contact2-Phone.", example = "1132323232")
    @Size(max = 64, message = "Contact2-Phone length cannot exceed 64 characters.")
    private String contact2Telephone;

    @Schema(description = "Contact2-email.", example = "s2@bydglobal.com")
    @Size(max = 255, message = "Contact2-email length cannot exceed 255 characters.")
    @Email(message = "Contact2-email format is invalid.")
    private String contact2Email;

    @Schema(description = "Unified social credit code.", example = "11212121")
    @Size(max = 64, message = "Unified social credit code cannot exceed 64 characters.")
    private String creditCode;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
