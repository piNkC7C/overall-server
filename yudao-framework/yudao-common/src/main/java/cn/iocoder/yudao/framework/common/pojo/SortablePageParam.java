package cn.iocoder.yudao.framework.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "Can sort page parameter.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SortablePageParam extends PageParam {

    @Schema(description = "Sort field.")
    private List<SortingField> sortingFields;

}