package cn.iocoder.yudao.module.infra.controller.app.file;

import cn.hutool.core.io.IoUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.FileCreateReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.file.vo.file.FilePresignedUrlRespVO;
import cn.iocoder.yudao.module.infra.controller.app.file.vo.AppFileUploadReqVO;
import cn.iocoder.yudao.module.infra.service.file.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "User App - file storage.")
@RestController
@RequestMapping("/infra/file")
@Validated
@Slf4j
public class AppFileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    @Operation(summary = "Upload File")
    @Parameter(name = "file", description = "FileAttachment.", required = true,
            schema = @Schema(type = "string", format = "binary"))
    public CommonResult<String> uploadFile(@Valid AppFileUploadReqVO uploadReqVO) throws Exception {
        MultipartFile file = uploadReqVO.getFile();
        byte[] content = IoUtil.readBytes(file.getInputStream());
        return success(fileService.createFile(content, file.getOriginalFilename(),
                uploadReqVO.getDirectory(), file.getContentType()));
    }

    @GetMapping("/presigned-url")
    @Operation(summary = "Get a presigned upload URL.", description = "Mode 2: frontend upload. Used when the frontend uploads directly to Qiniu, Alibaba Cloud OSS, or another store.")
    @Parameters({
            @Parameter(name = "name", description = "File name.", required = true),
            @Parameter(name = "directory", description = "File directory.")
    })
    public CommonResult<FilePresignedUrlRespVO> getFilePresignedUrl(
            @RequestParam("name") String name,
            @RequestParam(value = "directory", required = false) String directory) {
        return success(fileService.presignPutUrl(name, directory));
    }

    @PostMapping("/create")
    @Operation(summary = "Create file.", description = "Mode 2: frontend upload. Used with the presigned-url API to record the uploaded file.")
    public CommonResult<Long> createFile(@Valid @RequestBody FileCreateReqVO createReqVO) {
        return success(fileService.createFile(createReqVO));
    }

}
