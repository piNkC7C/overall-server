package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Cloud-drive space response VO.")
@Data
public class OaFileStorageRespVO {

    @Schema(description = "Used capacity in bytes.", example = "1024")
    private Long usedSize;

    @Schema(description = "Total capacity in bytes.", example = "1073741824")
    private Long totalSize;

    @Schema(description = "My active file count, excluding folders and trash.", example = "1")
    private Long fileCount;

    @Schema(description = "My active shared-node count, deduped by file or folder.", example = "1")
    private Long sharedCount;

    @Schema(description = "Received share-entry count. Child nodes are not counted again.", example = "1")
    private Long receivedCount;

}
