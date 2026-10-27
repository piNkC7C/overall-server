package cn.iocoder.yudao.module.mp.controller.admin.material.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Official account temporary media upload request VO.")
@Data
public class MpMaterialUploadTemporaryReqVO {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

    @Schema(description = "File type see WxConsts.MediaFileType enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "image")
    @NotEmpty(message = "File type is required.")
    private String type;

    @Schema(description = "FileAttachment.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "File is required.")
    @JsonIgnore // 避免被操作日志，进行序列化，导致报错
    private MultipartFile file;

}
