package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.room;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - Meeting roompage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaMeetingRoomPageReqVO extends PageParam {

    @Schema(description = "Room Name", example = "Room 101")
    private String name;

    @Schema(description = "Location", example = "Building 1, Room 101")
    private String location;

    @Schema(description = "Type.", example = "1")
    private Integer type;

    @Schema(description = "Can status.", example = "0")
    private Integer status;

    @Schema(description = "Owner person Name.", example = "Overall.")
    private String managerName;

}
