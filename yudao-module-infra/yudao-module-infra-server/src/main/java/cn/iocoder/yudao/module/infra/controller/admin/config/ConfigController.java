package cn.iocoder.yudao.module.infra.controller.admin.config;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.infra.controller.admin.config.vo.ConfigPageReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.config.vo.ConfigRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.config.vo.ConfigSaveReqVO;
import cn.iocoder.yudao.module.infra.convert.config.ConfigConvert;
import cn.iocoder.yudao.module.infra.dal.dataobject.config.ConfigDO;
import cn.iocoder.yudao.module.infra.enums.ErrorCodeConstants;
import cn.iocoder.yudao.module.infra.service.config.ConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - setting.")
@RestController
@RequestMapping("/infra/config")
@Validated
public class ConfigController {

    @Resource
    private ConfigService configService;

    @PostMapping("/create")
    @Operation(summary = "Createsetting.")
    @PreAuthorize("@ss.hasPermission('infra:config:create')")
    public CommonResult<Long> createConfig(@Valid @RequestBody ConfigSaveReqVO createReqVO) {
        return success(configService.createConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit setting.")
    @PreAuthorize("@ss.hasPermission('infra:config:update')")
    public CommonResult<Boolean> updateConfig(@Valid @RequestBody ConfigSaveReqVO updateReqVO) {
        configService.updateConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletesetting.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:config:delete')")
    public CommonResult<Boolean> deleteConfig(@RequestParam("id") Long id) {
        configService.deleteConfig(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Batch deletesetting.")
    @Parameter(name = "ids", description = "Code list.", required = true)
    @PreAuthorize("@ss.hasPermission('infra:config:delete')")
    public CommonResult<Boolean> deleteConfigList(@RequestParam("ids") List<Long> ids) {
        configService.deleteConfigList(ids);
        return success(true);
    }

    @GetMapping(value = "/get")
    @Operation(summary = "Get setting.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<ConfigRespVO> getConfig(@RequestParam("id") Long id) {
        return success(ConfigConvert.INSTANCE.convert(configService.getConfig(id)));
    }

    @GetMapping(value = "/get-value-by-key")
    @Operation(summary = "Get a setting value by key.", description = "Hidden setting. Do not return to the frontend.")
    @Parameter(name = "key", description = "ParameterKey.", required = true, example = "yunai.biz.username")
    public CommonResult<String> getConfigKey(@RequestParam("key") String key) {
        ConfigDO config = configService.getConfigByKey(key);
        if (config == null) {
            return success(null);
        }
        if (!config.getVisible()) {
            throw exception(ErrorCodeConstants.CONFIG_GET_VALUE_ERROR_IF_VISIBLE);
        }
        return success(config.getValue());
    }

    @GetMapping("/page")
    @Operation(summary = "Get setting page.")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<PageResult<ConfigRespVO>> getConfigPage(@Valid ConfigPageReqVO pageReqVO) {
        PageResult<ConfigDO> page = configService.getConfigPage(pageReqVO);
        return success(ConfigConvert.INSTANCE.convertPage(page));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportsetting.")
    @PreAuthorize("@ss.hasPermission('infra:config:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportConfig(ConfigPageReqVO exportReqVO,
                             HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ConfigDO> list = configService.getConfigPage(exportReqVO).getList();
        // 输出
        ExcelUtils.write(response, "Config Parameters.xls", "Data", ConfigRespVO.class,
                ConfigConvert.INSTANCE.convertList(list));
    }

}
