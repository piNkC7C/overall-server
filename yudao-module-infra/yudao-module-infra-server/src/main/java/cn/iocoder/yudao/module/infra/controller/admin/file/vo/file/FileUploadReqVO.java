package cn.iocoder.yudao.module.infra.controller.admin.file.vo.file;

import cn.iocoder.yudao.module.infra.framework.file.core.utils.FilePathUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "Admin - Upload File request.")
@Data
public class FileUploadReqVO {

    @Schema(description = "FileAttachment.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "FileAttachment is required.")
    private MultipartFile file;

    @Schema(description = "File directory.", example = "XXX/YYY")
    private String directory;

    @AssertTrue(message = "File directory is invalid.")
    @JsonIgnore
    public boolean isDirectoryValid() {
        return isDirectoryValid(directory);
    }

    public static boolean isDirectoryValid(String directory) {
        return FilePathUtils.isDirectoryValid(directory);
    }

}
