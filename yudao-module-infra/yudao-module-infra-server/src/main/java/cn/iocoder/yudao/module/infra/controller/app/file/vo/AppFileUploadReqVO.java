package cn.iocoder.yudao.module.infra.controller.app.file.vo;

import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.FileUploadReqVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "用户 App - 上传文件 Request VO")
@Data
public class AppFileUploadReqVO {

    @Schema(description = "文件附件", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "FileAttachment is required.")
    private MultipartFile file;

    @Schema(description = "文件目录", example = "XXX/YYY")
    private String directory;

    @AssertTrue(message = "File directory is invalid.")
    @JsonIgnore
    public boolean isDirectoryValid() {
        return FileUploadReqVO.isDirectoryValid(directory);
    }

}
