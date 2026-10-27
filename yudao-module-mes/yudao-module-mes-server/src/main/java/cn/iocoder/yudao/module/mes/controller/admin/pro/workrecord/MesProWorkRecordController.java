package cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo.MesProWorkRecordLogPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo.MesProWorkRecordLogRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo.MesProWorkRecordRespVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkstationDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workrecord.MesProWorkRecordDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.workrecord.MesProWorkRecordLogDO;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkstationService;
import cn.iocoder.yudao.module.mes.service.pro.workrecord.MesProWorkRecordService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
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
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - MES Work Record.")
@RestController
@RequestMapping("/mes/pro/workrecord")
@Validated
public class MesProWorkRecordController {

    @Resource
    private MesProWorkRecordService workRecordService;
    @Resource
    private MesMdWorkstationService workstationService;

    @Resource
    private AdminUserApi adminUserApi;

    @GetMapping("/log/page")
    @Operation(summary = "Get a work-record ledger page.")
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:query')")
    public CommonResult<PageResult<MesProWorkRecordLogRespVO>> getWorkRecordLogPage(
            @Valid MesProWorkRecordLogPageReqVO pageReqVO) {
        PageResult<MesProWorkRecordLogDO> pageResult = workRecordService.getWorkRecordLogPage(pageReqVO);
        return success(new PageResult<>(buildWorkRecordLogRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/log/get")
    @Operation(summary = "Get a work-record ledger entry.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:query')")
    public CommonResult<MesProWorkRecordLogRespVO> getWorkRecordLog(@RequestParam("id") Long id) {
        MesProWorkRecordLogDO log = workRecordService.getWorkRecordLog(id);
        return success(buildWorkRecordLogRespVO(log));
    }

    @GetMapping("/log/export-excel")
    @Operation(summary = "Export work records to Excel.")
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportWorkRecordLogExcel(@Valid MesProWorkRecordLogPageReqVO pageReqVO,
                                       HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesProWorkRecordLogDO> list = workRecordService.getWorkRecordLogPage(pageReqVO).getList();
        List<MesProWorkRecordLogRespVO> voList = buildWorkRecordLogRespVOList(list);
        ExcelUtils.write(response, "Work Records.xls", "Data", MesProWorkRecordLogRespVO.class, voList);
    }

    @PutMapping("/clock-in")
    @Operation(summary = "Go live (bind workstation).")
    @Parameter(name = "workstationId", description = "Workstation code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:clock')")
    public CommonResult<Long> clockInWorkRecord(@RequestParam("workstationId") Long workstationId) {
        return success(workRecordService.clockInWorkRecord(getLoginUserId(), workstationId));
    }

    @PutMapping("/clock-out")
    @Operation(summary = "Take offline (unbind workstation).")
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:clock')")
    public CommonResult<Long> clockOutWorkRecord() {
        return success(workRecordService.clockOutWorkRecord(getLoginUserId()));
    }

    @GetMapping("/get-my")
    @Operation(summary = "Get current user bind workstation status.")
    @PreAuthorize("@ss.hasPermission('mes:pro-workrecord:query')")
    public CommonResult<MesProWorkRecordRespVO> getMyWorkRecord() {
        MesProWorkRecordDO record = workRecordService.getWorkRecord(getLoginUserId());
        return success(buildWorkRecordRespVO(record));
    }

    // ==================== 拼接 VO ====================

    private MesProWorkRecordLogRespVO buildWorkRecordLogRespVO(MesProWorkRecordLogDO log) {
        if (log == null) {
            return null;
        }
        return buildWorkRecordLogRespVOList(Collections.singletonList(log)).get(0);
    }

    private List<MesProWorkRecordLogRespVO> buildWorkRecordLogRespVOList(List<MesProWorkRecordLogDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. 查询相关数据
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesProWorkRecordLogDO::getUserId));
        Map<Long, MesMdWorkstationDO> workstationMap = workstationService.getWorkstationMap(
                convertSet(list, MesProWorkRecordLogDO::getWorkstationId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesProWorkRecordLogRespVO.class, vo -> {
            findAndThen(userMap, vo.getUserId(), user ->
                    vo.setUserNickname(user.getNickname()));
            findAndThen(workstationMap, vo.getWorkstationId(), ws ->
                    vo.setWorkstationCode(ws.getCode()).setWorkstationName(ws.getName()));
        });
    }

    private MesProWorkRecordRespVO buildWorkRecordRespVO(MesProWorkRecordDO record) {
        if (record == null) {
            return null;
        }
        MesProWorkRecordRespVO vo = BeanUtils.toBean(record, MesProWorkRecordRespVO.class);
        // 拼接工作站信息
        MesMdWorkstationDO ws = workstationService.getWorkstation(record.getWorkstationId());
        if (ws != null) {
            vo.setWorkstationCode(ws.getCode()).setWorkstationName(ws.getName());
        }
        // 拼接用户信息
        AdminUserRespDTO user = adminUserApi.getUser(record.getUserId()).getCheckedData();
        if (user != null) {
            vo.setUserNickname(user.getNickname());
        }
        return vo;
    }

}
