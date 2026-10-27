package cn.iocoder.yudao.module.infra.controller.admin.redis.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Properties;

@Schema(description = "Redis monitor info response VO.")
@Data
@Builder
@AllArgsConstructor
public class RedisMonitorRespVO {

    @Schema(description = "Redis INFO result. See the Redis docs for fields.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Properties info;

    @Schema(description = "Redis key quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long dbSize;

    @Schema(description = "CommandStat Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<CommandStat> commandStats;

    @Schema(description = "Redis command stats.")
    @Data
    @Builder
    @AllArgsConstructor
    public static class CommandStat {

        @Schema(description = "Redis command.", requiredMode = Schema.RequiredMode.REQUIRED, example = "get")
        private String command;

        @Schema(description = "Call count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long calls;

        @Schema(description = "CPU seconds.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
        private Long usec;

    }

}
