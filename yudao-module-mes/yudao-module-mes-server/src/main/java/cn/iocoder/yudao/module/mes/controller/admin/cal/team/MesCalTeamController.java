package cn.iocoder.yudao.module.mes.controller.admin.cal.team;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.MesCalTeamPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.MesCalTeamRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.MesCalTeamSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.cal.team.MesCalTeamDO;
import cn.iocoder.yudao.module.mes.service.cal.team.MesCalTeamService;
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
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES team.")
@RestController
@RequestMapping("/mes/cal/team")
@Validated
public class MesCalTeamController {

    @Resource
    private MesCalTeamService teamService;

    @PostMapping("/create")
    @Operation(summary = "Create team.")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:create')")
    public CommonResult<Long> createTeam(@Valid @RequestBody MesCalTeamSaveReqVO createReqVO) {
        return success(teamService.createTeam(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update team.")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:update')")
    public CommonResult<Boolean> updateTeam(@Valid @RequestBody MesCalTeamSaveReqVO updateReqVO) {
        teamService.updateTeam(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete team.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:cal-team:delete')")
    public CommonResult<Boolean> deleteTeam(@RequestParam("id") Long id) {
        teamService.deleteTeam(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get team.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:query')")
    public CommonResult<MesCalTeamRespVO> getTeam(@RequestParam("id") Long id) {
        MesCalTeamDO team = teamService.getTeam(id);
        return success(BeanUtils.toBean(team, MesCalTeamRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get team page.")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:query')")
    public CommonResult<PageResult<MesCalTeamRespVO>> getTeamPage(@Valid MesCalTeamPageReqVO pageReqVO) {
        PageResult<MesCalTeamDO> pageResult = teamService.getTeamPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesCalTeamRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get team list.")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:query')")
    public CommonResult<List<MesCalTeamRespVO>> getTeamList() {
        List<MesCalTeamDO> list = teamService.getTeamList();
        return success(BeanUtils.toBean(list, MesCalTeamRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export team Excel.")
    @PreAuthorize("@ss.hasPermission('mes:cal-team:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTeamExcel(@Valid MesCalTeamPageReqVO pageReqVO,
                                HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesCalTeamDO> list = teamService.getTeamPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Teams.xls", "Data", MesCalTeamRespVO.class,
                BeanUtils.toBean(list, MesCalTeamRespVO.class));
    }

}
