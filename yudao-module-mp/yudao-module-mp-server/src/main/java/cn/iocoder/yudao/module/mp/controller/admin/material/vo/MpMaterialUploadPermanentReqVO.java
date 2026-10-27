package cn.iocoder.yudao.module.mp.controller.admin.material.vo;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Official account permanent media upload request VO.")
@Data
public class MpMaterialUploadPermanentReqVO {

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

    @Schema(description = "Name. If empty, the uploaded file name is used.", example = "wechat.mp")
    private String name;

    @Schema(description = "Video title. Required when the file type is video.", example = "Video media title.")
    private String title;
    @Schema(description = "Video description. Required when the file type is video.", example = "Video media Description.")
    private String introduction;

    @AssertTrue(message = "Title is required.")
    public boolean isTitleValid() {
        // 生成场景为管理后台时，必须设置上级菜单，不然生成的菜单 SQL 是无父级菜单的
        return ObjectUtil.notEqual(type, WxConsts.MediaFileType.VIDEO)
                || title != null;
    }

    @AssertTrue(message = "Description is required.")
    public boolean isIntroductionValid() {
        // 生成场景为管理后台时，必须设置上级菜单，不然生成的菜单 SQL 是无父级菜单的
        return ObjectUtil.notEqual(type, WxConsts.MediaFileType.VIDEO)
                || introduction != null;
    }

}
