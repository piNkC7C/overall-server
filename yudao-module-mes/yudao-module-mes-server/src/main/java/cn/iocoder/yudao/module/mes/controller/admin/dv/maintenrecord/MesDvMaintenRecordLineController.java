package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line.MesDvMaintenRecordLinePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line.MesDvMaintenRecordLineRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line.MesDvMaintenRecordLineSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.maintenrecord.MesDvMaintenRecordLineDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.subject.MesDvSubjectDO;
import cn.iocoder.yudao.module.mes.service.dv.maintenrecord.MesDvMaintenRecordLineService;
import cn.iocoder.yudao.module.mes.service.dv.subject.MesDvSubjectService;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES device maintenance recorddetail.")
@RestController
@RequestMapping("/mes/dv/mainten-record-line")
@Validated
public class MesDvMaintenRecordLineController {

    @Resource
    private MesDvMaintenRecordLineService maintenRecordLineService;
    @Resource
    private MesDvSubjectService subjectService;

    @PostMapping("/create")
    @Operation(summary = "Createdevice maintenance recorddetail.")
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:create')")
    public CommonResult<Long> createMaintenRecordLine(@Valid @RequestBody MesDvMaintenRecordLineSaveReqVO createReqVO) {
        return success(maintenRecordLineService.createMaintenRecordLine(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedevice maintenance recorddetail.")
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:update')")
    public CommonResult<Boolean> updateMaintenRecordLine(@Valid @RequestBody MesDvMaintenRecordLineSaveReqVO updateReqVO) {
        maintenRecordLineService.updateMaintenRecordLine(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedevice maintenance recorddetail.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:delete')")
    public CommonResult<Boolean> deleteMaintenRecordLine(@RequestParam("id") Long id) {
        maintenRecordLineService.deleteMaintenRecordLine(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device maintenance recorddetail.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:query')")
    public CommonResult<MesDvMaintenRecordLineRespVO> getMaintenRecordLine(@RequestParam("id") Long id) {
        MesDvMaintenRecordLineDO maintenRecordLine = maintenRecordLineService.getMaintenRecordLine(id);
        if (maintenRecordLine == null) {
            return success(null);
        }
        return success(buildMaintenRecordLineRespVOList(Collections.singletonList(maintenRecordLine)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get device maintenance recorddetail page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:query')")
    public CommonResult<PageResult<MesDvMaintenRecordLineRespVO>> getMaintenRecordLinePage(@Valid MesDvMaintenRecordLinePageReqVO pageReqVO) {
        PageResult<MesDvMaintenRecordLineDO> pageResult = maintenRecordLineService.getMaintenRecordLinePage(pageReqVO);
        return success(new PageResult<>(buildMaintenRecordLineRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list-by-record-id")
    @Operation(summary = "Get specified maintenance record detail list.")
    @Parameter(name = "recordId", description = "Maintenance record code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:query')")
    public CommonResult<List<MesDvMaintenRecordLineRespVO>> getMaintenRecordLineListByRecordId(
            @RequestParam("recordId") Long recordId) {
        List<MesDvMaintenRecordLineDO> list = maintenRecordLineService.getMaintenRecordLineListByRecordId(recordId);
        return success(buildMaintenRecordLineRespVOList(list));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportdevice maintenance recorddetail Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-mainten-record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMaintenRecordLineExcel(@Valid MesDvMaintenRecordLinePageReqVO pageReqVO,
                                              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvMaintenRecordLineDO> list = maintenRecordLineService.getMaintenRecordLinePage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Equipment Maintenance Record Details.xls", "Data", MesDvMaintenRecordLineRespVO.class,
                buildMaintenRecordLineRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesDvMaintenRecordLineRespVO> buildMaintenRecordLineRespVOList(List<MesDvMaintenRecordLineDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get relation data
        Map<Long, MesDvSubjectDO> subjectMap = subjectService.getSubjectMap(
                convertSet(list, MesDvMaintenRecordLineDO::getSubjectId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesDvMaintenRecordLineRespVO.class, vo ->
                MapUtils.findAndThen(subjectMap, vo.getSubjectId(), subject -> vo
                        .setSubjectName(subject.getName()).setSubjectContent(subject.getContent())
                        .setSubjectStandard(subject.getStandard())));
    }

}
