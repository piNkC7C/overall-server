package cn.iocoder.yudao.module.pms.controller.admin.kb.content.vo.document;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Knowledge-base global document search page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsKnowledgeDocumentSearchPageReqVO extends PageParam {

    @Schema(description = "Search keyword.", example = "Product plan.")
    private String keyword;

    @Schema(description = "Knowledge base code.", example = "1024")
    private Long libraryId;

    @Schema(description = "Creator user ID.", example = "1")
    private Long creatorUserId;

    @Schema(description = "Update time range.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

}
