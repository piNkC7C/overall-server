package cn.iocoder.yudao.module.infra.controller.app.file.vo;

import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.FileUploadReqVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "User App - Upload File request.")
@Data
public class AppFileUploadReqVO {

    @Schema(description = "FileAttachment.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "FileAttachment is required.")
    private MultipartFile file;

    @Schema(description = "File directory.", example = "XXX/YYY")
    private String directory;

    @AssertTrue(message = "File directory is invalid.")
    @JsonIgnore
    public boolean isDirectoryValid() {
        return FileUploadReqVO.isDirectoryValid(directory);
    }

}
