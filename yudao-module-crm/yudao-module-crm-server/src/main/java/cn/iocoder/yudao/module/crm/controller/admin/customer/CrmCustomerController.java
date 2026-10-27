package cn.iocoder.yudao.module.crm.controller.admin.customer;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.ip.core.utils.AreaUtils;
import cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer.*;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerPoolConfigDO;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerPoolConfigService;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.pojo.PageParam.PAGE_SIZE_NONE;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static java.util.Collections.singletonList;

@Tag(name = "Admin - CRM customer.")
@RestController
@RequestMapping("/crm/customer")
@Validated
public class CrmCustomerController {

    @Resource
    private CrmCustomerService customerService;
    @Resource
    private CrmCustomerPoolConfigService customerPoolConfigService;

    @Resource
    private DeptApi deptApi;
    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createcustomer.")
    @PreAuthorize("@ss.hasPermission('crm:customer:create')")
    public CommonResult<Long> createCustomer(@Valid @RequestBody CrmCustomerSaveReqVO createReqVO) {
        return success(customerService.createCustomer(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatecustomer.")
    @PreAuthorize("@ss.hasPermission('crm:customer:update')")
    public CommonResult<Boolean> updateCustomer(@Valid @RequestBody CrmCustomerSaveReqVO updateReqVO) {
        customerService.updateCustomer(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-deal-status")
    @Operation(summary = "Updatecustomer Won status.")
    @Parameters({
            @Parameter(name = "id", description = "Customer code.", required = true),
            @Parameter(name = "dealStatus", description = "Won status.", required = true)
    })
    public CommonResult<Boolean> updateCustomerDealStatus(@RequestParam("id") Long id,
                                                          @RequestParam("dealStatus") Boolean dealStatus) {
        customerService.updateCustomerDealStatus(id, dealStatus);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletecustomer.")
    @Parameter(name = "id", description = "Customer code.", required = true)
    @PreAuthorize("@ss.hasPermission('crm:customer:delete')")
    public CommonResult<Boolean> deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get customer.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<CrmCustomerRespVO> getCustomer(@RequestParam("id") Long id) {
        // 1. get customer
        CrmCustomerDO customer = customerService.getCustomer(id);
        // 2. 拼接数据
        return success(buildCustomerDetail(customer));
    }

    public CrmCustomerRespVO buildCustomerDetail(CrmCustomerDO customer) {
        if (customer == null) {
            return null;
        }
        return buildCustomerDetailList(singletonList(customer)).get(0);
    }

    @GetMapping("/page")
    @Operation(summary = "Get customer page.")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<PageResult<CrmCustomerRespVO>> getCustomerPage(@Valid CrmCustomerPageReqVO pageVO) {
        // 1. searchcustomer page
        PageResult<CrmCustomerDO> pageResult = customerService.getCustomerPage(pageVO, getLoginUserId());
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }
        // 2. 拼接数据
        return success(new PageResult<>(buildCustomerDetailList(pageResult.getList()), pageResult.getTotal()));
    }

    public List<CrmCustomerRespVO> buildCustomerDetailList(List<CrmCustomerDO> list) {
        if (CollUtil.isEmpty(list)) {
            return java.util.Collections.emptyList();
        }
        // 1.1 get creator 、 owner person list
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertSetByFlatMap(list,
                contact -> Stream.of(NumberUtils.parseLong(contact.getCreator()), contact.getOwnerUserId())));
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        // 1.2 获取距离进入公海的时间
        Map<Long, Long> poolDayMap = getPoolDayMap(list);
        // 2. 转换成 VO
        return BeanUtils.toBean(list, CrmCustomerRespVO.class, customerVO -> {
            customerVO.setAreaName(AreaUtils.format(customerVO.getAreaId()));
            // 2.1 set creator 、 owner person name
            MapUtils.findAndThen(userMap, NumberUtils.parseLong(customerVO.getCreator()),
                    user -> customerVO.setCreatorName(user.getNickname()));
            MapUtils.findAndThen(userMap, customerVO.getOwnerUserId(), user -> {
                customerVO.setOwnerUserName(user.getNickname());
                MapUtils.findAndThen(deptMap, user.getDeptId(), dept -> customerVO.setOwnerUserDeptName(dept.getName()));
            });
            // 2.2 设置距离进入公海的时间
            if (customerVO.getOwnerUserId() != null) {
                customerVO.setPoolDay(poolDayMap.get(customerVO.getId()));
            }
        });
    }

    @GetMapping("/put-pool-remind-page")
    @Operation(summary = "Get a page of customers pending pool entry.")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<PageResult<CrmCustomerRespVO>> getPutPoolRemindCustomerPage(@Valid CrmCustomerPageReqVO pageVO) {
        // 1. searchcustomer page
        PageResult<CrmCustomerDO> pageResult = customerService.getPutPoolRemindCustomerPage(pageVO, getLoginUserId());
        // 2. 拼接数据
        return success(new PageResult<>(buildCustomerDetailList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/put-pool-remind-count")
    @Operation(summary = "Get customers pending pool entry.")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<Long> getPutPoolRemindCustomerCount() {
        return success(customerService.getPutPoolRemindCustomerCount(getLoginUserId()));
    }

    @GetMapping("/today-contact-count")
    @Operation(summary = "Get customers to contact today.")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<Long> getTodayContactCustomerCount() {
        return success(customerService.getTodayContactCustomerCount(getLoginUserId()));
    }

    @GetMapping("/follow-count")
    @Operation(summary = "Get my assigned customers pending follow-up.")
    @PreAuthorize("@ss.hasPermission('crm:customer:query')")
    public CommonResult<Long> getFollowCustomerCount() {
        return success(customerService.getFollowCustomerCount(getLoginUserId()));
    }

    /**
     * 获取距离进入公海的时间 Map
     *
     * @param list 客户列表
     * @return key 客户编号, value 距离进入公海的时间
     */
    private Map<Long, Long> getPoolDayMap(List<CrmCustomerDO> list) {
        CrmCustomerPoolConfigDO poolConfig = customerPoolConfigService.getCustomerPoolConfig();
        if (poolConfig == null || !poolConfig.getEnabled()) {
            return MapUtil.empty();
        }
        list = CollectionUtils.filterList(list, customer -> {
            // 特殊：如果没负责人，则说明已经在公海，不用计算
            if (customer.getOwnerUserId() == null) {
                return false;
            }
            // 已成交 or 已锁定，不进入公海
            return !customer.getDealStatus() && !customer.getLockStatus();
        });
        return convertMap(list, CrmCustomerDO::getId, customer -> {
            // 1.1 未成交放入公海天数
            long dealExpireDay = poolConfig.getDealExpireDays() - LocalDateTimeUtils.between(customer.getOwnerTime());
            // 1.2 未跟进放入公海天数
            LocalDateTime lastTime = customer.getOwnerTime();
            if (customer.getContactLastTime() != null && customer.getContactLastTime().isAfter(lastTime)) {
                lastTime = customer.getContactLastTime();
            }
            long contactExpireDay = poolConfig.getContactExpireDays() - LocalDateTimeUtils.between(lastTime);
            // 2. 返回最小的天数
            long poolDay = Math.min(dealExpireDay, contactExpireDay);
            return poolDay > 0 ? poolDay : 0;
        });
    }

    @GetMapping(value = "/simple-list")
    @Operation(summary = "Get customer simple info list.", description = "Only customers with read permission. Used for dropdowns.")
    public CommonResult<List<CrmCustomerRespVO>> getCustomerSimpleList() {
        CrmCustomerPageReqVO reqVO = new CrmCustomerPageReqVO();
        reqVO.setPageSize(PAGE_SIZE_NONE); // Not page
        List<CrmCustomerDO> list = customerService.getCustomerPage(reqVO, getLoginUserId()).getList();
        return success(convertList(list, customer -> // 只返回 id、name 精简字段
                new CrmCustomerRespVO().setId(customer.getId()).setName(customer.getName())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportcustomer Excel.")
    @PreAuthorize("@ss.hasPermission('crm:customer:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCustomerExcel(@Valid CrmCustomerPageReqVO pageVO,
                                    HttpServletResponse response) throws IOException {
        pageVO.setPageSize(PAGE_SIZE_NONE); // Not page
        List<CrmCustomerDO> list = customerService.getCustomerPage(pageVO, getLoginUserId()).getList();
        // Export Excel
        ExcelUtils.write(response, "Customers.xls", "Data", CrmCustomerRespVO.class,
                buildCustomerDetailList(list));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get importcustomertemplate.")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<CrmCustomerImportExcelVO> list = Arrays.asList(
                CrmCustomerImportExcelVO.builder().name("Acme").industryId(1).level(1).source(1)
                        .mobile("15555550100").telephone("").qq("").wechat("").email("sales@example.com")
                        .areaId(null).detailAddress("").remark("").build(),
                CrmCustomerImportExcelVO.builder().name("Contoso").industryId(1).level(1).source(1)
                        .mobile("15555550101").telephone("").qq("").wechat("").email("hello@example.com")
                        .areaId(null).detailAddress("").remark("").build()
        );
        // 输出
        ExcelUtils.write(response, "Customer Import Template.xls", "Customers", CrmCustomerImportExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "Importcustomer.")
    @PreAuthorize("@ss.hasPermission('crm:customer:import')")
    public CommonResult<CrmCustomerImportRespVO> importExcel(@Valid CrmCustomerImportReqVO importReqVO)
            throws Exception {
        List<CrmCustomerImportExcelVO> list = ExcelUtils.read(importReqVO.getFile(), CrmCustomerImportExcelVO.class);
        return success(customerService.importCustomerList(list, importReqVO));
    }

    @PutMapping("/transfer")
    @Operation(summary = "Transfer customer.")
    @PreAuthorize("@ss.hasPermission('crm:customer:update')")
    public CommonResult<Boolean> transferCustomer(@Valid @RequestBody CrmCustomerTransferReqVO reqVO) {
        customerService.transferCustomer(reqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/lock")
    @Operation(summary = "Lock or unlock a customer.")
    @PreAuthorize("@ss.hasPermission('crm:customer:update')")
    public CommonResult<Boolean> lockCustomer(@Valid @RequestBody CrmCustomerLockReqVO lockReqVO) {
        customerService.lockCustomer(lockReqVO, getLoginUserId());
        return success(true);
    }

    // ==================== 公海相关操作 ====================

    @PutMapping("/put-pool")
    @Operation(summary = "Move the record to the pool.")
    @Parameter(name = "id", description = "Customer code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('crm:customer:update')")
    public CommonResult<Boolean> putCustomerPool(@RequestParam("id") Long id) {
        customerService.putCustomerPool(id);
        return success(true);
    }

    @PutMapping("/receive")
    @Operation(summary = "Claim a pool customer.")
    @Parameter(name = "ids", description = "ID list.", required = true, example = "1,2,3")
    @PreAuthorize("@ss.hasPermission('crm:customer:receive')")
    public CommonResult<Boolean> receiveCustomer(@RequestParam(value = "ids") List<Long> ids) {
        customerService.receiveCustomer(ids, getLoginUserId(), Boolean.TRUE);
        return success(true);
    }

    @PutMapping("/distribute")
    @Operation(summary = "Assign a pool customer to an owner.")
    @PreAuthorize("@ss.hasPermission('crm:customer:distribute')")
    public CommonResult<Boolean> distributeCustomer(@Valid @RequestBody CrmCustomerDistributeReqVO distributeReqVO) {
        customerService.receiveCustomer(distributeReqVO.getIds(), distributeReqVO.getOwnerUserId(), Boolean.FALSE);
        return success(true);
    }

}
