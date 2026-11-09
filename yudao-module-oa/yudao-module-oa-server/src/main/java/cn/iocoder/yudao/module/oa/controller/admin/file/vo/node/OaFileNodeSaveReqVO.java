package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFileNodeTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "管理后台 - 云盘文件新增 Request VO")
@Data
public class OaFileNodeSaveReqVO {

    @Schema(description = "父目录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Parent directory code is required.")
    private Long parentId;

    @Schema(description = "节点类型：0 文件夹、1 文件", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Node type is required.")
    @InEnum(value = OaFileNodeTypeEnum.class, message = "Node type must be {value}.")
    private Integer type;

    @Schema(description = "节点名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "office-supply-count.pdf")
    @NotBlank(message = "Node name is required.")
    @Size(max = 255, message = "Node name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "上传文件地址，文件夹不传", example = "https://example.com/file.pdf")
    @Size(max = 2048, message = "FileAddress length cannot exceed 2048 characters.")
    private String url;

    @Schema(description = "文件大小，单位字节，文件夹不传", example = "1024")
    private Long size;

    @AssertTrue(message = "FileAddress is required.")
    @JsonIgnore
    public boolean isUrlValid() {
        return ObjUtil.notEqual(type, OaFileNodeTypeEnum.FILE.getType()) || StrUtil.isNotBlank(url);
    }

    @AssertTrue(message = "File size cannot be less than 0.")
    @JsonIgnore
    public boolean isSizeValid() {
        return ObjUtil.notEqual(type, OaFileNodeTypeEnum.FILE.getType()) || (size != null && size >= 0);
    }

}
