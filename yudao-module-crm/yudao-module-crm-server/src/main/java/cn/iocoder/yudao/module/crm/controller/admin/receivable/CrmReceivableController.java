package cn.iocoder.yudao.module.crm.controller.admin.receivable;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract.CrmContractRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable.CrmReceivablePageReqVO;
import cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable.CrmReceivableRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable.CrmReceivableSaveReqVO;
import cn.iocoder.yudao.module.crm.dal.dataobject.contract.CrmContractDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.receivable.CrmReceivableDO;
import cn.iocoder.yudao.module.crm.service.contract.CrmContractService;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerService;
import cn.iocoder.yudao.module.crm.service.receivable.CrmReceivableService;
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
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - CRM collection.")
@RestController
@RequestMapping("/crm/receivable")
@Validated
public class CrmReceivableController {

    @Resource
    private CrmReceivableService receivableService;
    @Resource
    private CrmContractService contractService;
    @Resource
    private CrmCustomerService customerService;

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private DeptApi deptApi;

    @PostMapping("/create")
    @Operation(summary = "Createcollection.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:create')")
    public CommonResult<Long> createReceivable(@Valid @RequestBody CrmReceivableSaveReqVO createReqVO) {
        return success(receivableService.createReceivable(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatecollection.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:update')")
    public CommonResult<Boolean> updateReceivable(@Valid @RequestBody CrmReceivableSaveReqVO updateReqVO) {
        receivableService.updateReceivable(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletecollection.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('crm:receivable:delete')")
    public CommonResult<Boolean> deleteReceivable(@RequestParam("id") Long id) {
        receivableService.deleteReceivable(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get collection.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('crm:receivable:query')")
    public CommonResult<CrmReceivableRespVO> getReceivable(@RequestParam("id") Long id) {
        CrmReceivableDO receivable = receivableService.getReceivable(id);
        return success(buildReceivableDetail(receivable));
    }

    private CrmReceivableRespVO buildReceivableDetail(CrmReceivableDO receivable) {
        if (receivable == null) {
            return null;
        }
        return buildReceivableDetailList(Collections.singletonList(receivable)).get(0);
    }

    @GetMapping("/page")
    @Operation(summary = "Get collection page.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:query')")
    public CommonResult<PageResult<CrmReceivableRespVO>> getReceivablePage(@Valid CrmReceivablePageReqVO pageReqVO) {
        PageResult<CrmReceivableDO> pageResult = receivableService.getReceivablePage(pageReqVO, getLoginUserId());
        return success(new PageResult<>(buildReceivableDetailList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/page-by-customer")
    @Operation(summary = "Get collection page, based on specified Customer.")
    public CommonResult<PageResult<CrmReceivableRespVO>> getReceivablePageByCustomer(@Valid CrmReceivablePageReqVO pageReqVO) {
        Assert.notNull(pageReqVO.getCustomerId(), "Customer ID cannot be empty");
        PageResult<CrmReceivableDO> pageResult = receivableService.getReceivablePageByCustomerId(pageReqVO);
        return success(new PageResult<>(buildReceivableDetailList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportcollection Excel.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportReceivableExcel(@Valid CrmReceivablePageReqVO exportReqVO,
                                      HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PAGE_SIZE_NONE);
        List<CrmReceivableDO> list = receivableService.getReceivablePage(exportReqVO, getLoginUserId()).getList();
        // Export Excel
        ExcelUtils.write(response, "Collections.xls", "Data", CrmReceivableRespVO.class,
                buildReceivableDetailList(list));
    }

    private List<CrmReceivableRespVO> buildReceivableDetailList(List<CrmReceivableDO> receivableList) {
        if (CollUtil.isEmpty(receivableList)) {
            return Collections.emptyList();
        }
        // 1.1 get customer list
        Map<Long, CrmCustomerDO> customerMap = customerService.getCustomerMap(
                convertSet(receivableList, CrmReceivableDO::getCustomerId));
        // 1.2 get creator 、 owner person list
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertListByFlatMap(receivableList,
                contact -> Stream.of(NumberUtils.parseLong(contact.getCreator()), contact.getOwnerUserId())));
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        // 1.3 get contract list
        Map<Long, CrmContractDO> contractMap = contractService.getContractMap(
                convertSet(receivableList, CrmReceivableDO::getContractId));
        // 2. 拼接结果
        return BeanUtils.toBean(receivableList, CrmReceivableRespVO.class, (receivableVO) -> {
            // 2.1 拼接客户名称
            findAndThen(customerMap, receivableVO.getCustomerId(), customer -> receivableVO.setCustomerName(customer.getName()));
            // 2.2 拼接负责人、创建人名称
            MapUtils.findAndThen(userMap, NumberUtils.parseLong(receivableVO.getCreator()),
                    user -> receivableVO.setCreatorName(user.getNickname()));
            MapUtils.findAndThen(userMap, receivableVO.getOwnerUserId(), user -> {
                receivableVO.setOwnerUserName(user.getNickname());
                MapUtils.findAndThen(deptMap, user.getDeptId(), dept -> receivableVO.setOwnerUserDeptName(dept.getName()));
            });
            // 2.3 拼接合同信息
            findAndThen(contractMap, receivableVO.getContractId(), contract ->
                    receivableVO.setContract(BeanUtils.toBean(contract, CrmContractRespVO.class)));
        });
    }

    @PutMapping("/submit")
    @Operation(summary = "Submit collection approval.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:update')")
    public CommonResult<Boolean> submitContract(@RequestParam("id") Long id) {
        receivableService.submitReceivable(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/audit-count")
    @Operation(summary = "Get collections pending review.")
    @PreAuthorize("@ss.hasPermission('crm:receivable:query')")
    public CommonResult<Long> getAuditReceivableCount() {
        return success(receivableService.getAuditReceivableCount(getLoginUserId()));
    }

}
