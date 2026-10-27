package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.oa.enums.mail.OaMailFolderKeyEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - email page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaMailMessagePageReqVO extends PageParam {

    @Schema(description = "Email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Email account code is required.")
    private Long accountId;

    @Schema(description = "Folder type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "INBOX")
    @NotBlank(message = "Folder key is required.")
    private String folderKey;

    @Schema(description = "Subject or sender.", example = "Project review")
    @Size(max = 200, message = "Search keyword cannot exceed 200 characters.")
    private String keyword;

    @Schema(description = "Is not Read.", example = "false")
    private Boolean readStatus;

    @Schema(description = "Is not has Attachment.", example = "false")
    private Boolean hasAttach;

    /**
     * 校验文件夹入口
     *
     * @return 是否为标准入口或合法的自定义目录编号
     */
    @AssertTrue(message = "Folder key is invalid.")
    @JsonIgnore
    public boolean isFolderKeyValid() {
        if (StrUtil.isBlank(folderKey) || ArrayUtil.contains(OaMailFolderKeyEnum.ARRAYS, folderKey)) {
            return true; // 空值由 NotBlank 校验
        }
        return folderKey.matches("[1-9][0-9]{0,17}");
    }

}
