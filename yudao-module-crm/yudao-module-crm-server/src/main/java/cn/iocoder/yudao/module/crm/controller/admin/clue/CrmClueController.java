package cn.iocoder.yudao.module.crm.controller.admin.clue;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.ip.core.utils.AreaUtils;
import cn.iocoder.yudao.module.crm.controller.admin.clue.vo.CrmCluePageReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.clue.vo.CrmClueRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.clue.vo.CrmClueSaveReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.clue.vo.CrmClueTransferReqVO;
import cn.iocoder.yudao.module.crm.dal.dataobject.clue.CrmClueDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerDO;
import cn.iocoder.yudao.module.crm.service.clue.CrmClueService;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
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
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.pojo.PageParam.PAGE_SIZE_NONE;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertListByFlatMap;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static java.util.Collections.singletonList;

@Tag(name = "Admin - lead.")
@RestController
@RequestMapping("/crm/clue")
@Validated
public class CrmClueController {

    @Resource
    private CrmClueService clueService;
    @Resource
    private CrmCustomerService customerService;

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private DeptApi deptApi;

    @PostMapping("/create")
    @Operation(summary = "Createlead.")
    @PreAuthorize("@ss.hasPermission('crm:clue:create')")
    public CommonResult<Long> createClue(@Valid @RequestBody CrmClueSaveReqVO createReqVO) {
        return success(clueService.createClue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatelead.")
    @PreAuthorize("@ss.hasPermission('crm:clue:update')")
    public CommonResult<Boolean> updateClue(@Valid @RequestBody CrmClueSaveReqVO updateReqVO) {
        clueService.updateClue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletelead.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('crm:clue:delete')")
    public CommonResult<Boolean> deleteClue(@RequestParam("id") Long id) {
        clueService.deleteClue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get lead.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('crm:clue:query')")
    public CommonResult<CrmClueRespVO> getClue(@RequestParam("id") Long id) {
        CrmClueDO clue = clueService.getClue(id);
        return success(buildClueDetail(clue));
    }

    private CrmClueRespVO buildClueDetail(CrmClueDO clue) {
        if (clue == null) {
            return null;
        }
        return buildClueDetailList(singletonList(clue)).get(0);
    }

    @GetMapping("/page")
    @Operation(summary = "Get lead page.")
    @PreAuthorize("@ss.hasPermission('crm:clue:query')")
    public CommonResult<PageResult<CrmClueRespVO>> getCluePage(@Valid CrmCluePageReqVO pageVO) {
        PageResult<CrmClueDO> pageResult = clueService.getCluePage(pageVO, getLoginUserId());
        return success(new PageResult<>(buildClueDetailList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportlead Excel.")
    @PreAuthorize("@ss.hasPermission('crm:clue:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportClueExcel(@Valid CrmCluePageReqVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PAGE_SIZE_NONE);
        List<CrmClueDO> list = clueService.getCluePage(pageReqVO, getLoginUserId()).getList();
        // Export Excel
        ExcelUtils.write(response, "Leads.xls", "Data", CrmClueRespVO.class, buildClueDetailList(list));
    }

    private List<CrmClueRespVO> buildClueDetailList(List<CrmClueDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1.1 get customer list
        Map<Long, CrmCustomerDO> customerMap = customerService.getCustomerMap(
                convertSet(list, CrmClueDO::getCustomerId));
        // 1.2 get creator 、 owner person list
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertListByFlatMap(list,
                contact -> Stream.of(NumberUtils.parseLong(contact.getCreator()), contact.getOwnerUserId())));
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        // 2. 转换成 VO
        return BeanUtils.toBean(list, CrmClueRespVO.class, clueVO -> {
            clueVO.setAreaName(AreaUtils.format(clueVO.getAreaId()));
            // 2.1 setcustomer name
            MapUtils.findAndThen(customerMap, clueVO.getCustomerId(), customer -> clueVO.setCustomerName(customer.getName()));
            // 2.2 set creator 、 owner person name
            MapUtils.findAndThen(userMap, NumberUtils.parseLong(clueVO.getCreator()),
                    user -> clueVO.setCreatorName(user.getNickname()));
            MapUtils.findAndThen(userMap, clueVO.getOwnerUserId(), user -> {
                clueVO.setOwnerUserName(user.getNickname());
                MapUtils.findAndThen(deptMap, user.getDeptId(), dept -> clueVO.setOwnerUserDeptName(dept.getName()));
            });
        });
    }

    @PutMapping("/transfer")
    @Operation(summary = "Lead transfer.")
    @PreAuthorize("@ss.hasPermission('crm:clue:update')")
    public CommonResult<Boolean> transferClue(@Valid @RequestBody CrmClueTransferReqVO reqVO) {
        clueService.transferClue(reqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/transform")
    @Operation(summary = "Convert a lead to a customer.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('crm:clue:update')")
    public CommonResult<Boolean> transformClue(@RequestParam("id") Long id) {
        clueService.transformClue(id, getLoginUserId());
        return success(Boolean.TRUE);
    }

    @GetMapping("/follow-count")
    @Operation(summary = "Get my assigned leads pending follow-up.")
    @PreAuthorize("@ss.hasPermission('crm:clue:query')")
    public CommonResult<Long> getFollowClueCount() {
        return success(clueService.getFollowClueCount(getLoginUserId()));
    }

}
