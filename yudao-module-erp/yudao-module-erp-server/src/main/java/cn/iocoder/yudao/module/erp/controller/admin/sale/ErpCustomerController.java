package cn.iocoder.yudao.module.erp.controller.admin.sale;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer.ErpCustomerPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer.ErpCustomerRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer.ErpCustomerSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.sale.ErpCustomerDO;
import cn.iocoder.yudao.module.erp.service.sale.ErpCustomerService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - ERP customer.")
@RestController
@RequestMapping("/erp/customer")
@Validated
public class ErpCustomerController {

    @Resource
    private ErpCustomerService customerService;

    @PostMapping("/create")
    @Operation(summary = "Createcustomer.")
    @PreAuthorize("@ss.hasPermission('erp:customer:create')")
    public CommonResult<Long> createCustomer(@Valid @RequestBody ErpCustomerSaveReqVO createReqVO) {
        return success(customerService.createCustomer(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatecustomer.")
    @PreAuthorize("@ss.hasPermission('erp:customer:update')")
    public CommonResult<Boolean> updateCustomer(@Valid @RequestBody ErpCustomerSaveReqVO updateReqVO) {
        customerService.updateCustomer(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletecustomer.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:customer:delete')")
    public CommonResult<Boolean> deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get customer.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:customer:query')")
    public CommonResult<ErpCustomerRespVO> getCustomer(@RequestParam("id") Long id) {
        ErpCustomerDO customer = customerService.getCustomer(id);
        return success(BeanUtils.toBean(customer, ErpCustomerRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get customer page.")
    @PreAuthorize("@ss.hasPermission('erp:customer:query')")
    public CommonResult<PageResult<ErpCustomerRespVO>> getCustomerPage(@Valid ErpCustomerPageReqVO pageReqVO) {
        PageResult<ErpCustomerDO> pageResult = customerService.getCustomerPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpCustomerRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get customer simple list.", description = "Only enabled customer. Used for dropdowns.")
    public CommonResult<List<ErpCustomerRespVO>> getCustomerSimpleList() {
        List<ErpCustomerDO> list = customerService.getCustomerListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, customer -> new ErpCustomerRespVO().setId(customer.getId()).setName(customer.getName())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportcustomer Excel.")
    @PreAuthorize("@ss.hasPermission('erp:customer:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCustomerExcel(@Valid ErpCustomerPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpCustomerDO> list = customerService.getCustomerPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Customers.xls", "Data", ErpCustomerRespVO.class,
                        BeanUtils.toBean(list, ErpCustomerRespVO.class));
    }

}