package cn.iocoder.yudao.module.trade.controller.admin.delivery;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.express.*;
import cn.iocoder.yudao.module.trade.convert.delivery.DeliveryExpressConvert;
import cn.iocoder.yudao.module.trade.dal.dataobject.delivery.DeliveryExpressDO;
import cn.iocoder.yudao.module.trade.service.delivery.DeliveryExpressService;
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

@Tag(name = "Admin - carrier.")
@RestController
@RequestMapping("/trade/delivery/express")
@Validated
public class DeliveryExpressController {

    @Resource
    private DeliveryExpressService deliveryExpressService;

    @PostMapping("/create")
    @Operation(summary = "CreateCourier.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:create')")
    public CommonResult<Long> createDeliveryExpress(@Valid @RequestBody DeliveryExpressCreateReqVO createReqVO) {
        return success(deliveryExpressService.createDeliveryExpress(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateCourier.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:update')")
    public CommonResult<Boolean> updateDeliveryExpress(@Valid @RequestBody DeliveryExpressUpdateReqVO updateReqVO) {
        deliveryExpressService.updateDeliveryExpress(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteCourier.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:delete')")
    public CommonResult<Boolean> deleteDeliveryExpress(@RequestParam("id") Long id) {
        deliveryExpressService.deleteDeliveryExpress(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "GetCourier.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:query')")
    public CommonResult<DeliveryExpressRespVO> getDeliveryExpress(@RequestParam("id") Long id) {
        DeliveryExpressDO deliveryExpress = deliveryExpressService.getDeliveryExpress(id);
        return success(DeliveryExpressConvert.INSTANCE.convert(deliveryExpress));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get carrier simple list.", description = "Used by frontend select options.")
    public CommonResult<List<DeliveryExpressSimpleRespVO>> getSimpleDeliveryExpressList() {
        List<DeliveryExpressDO> list = deliveryExpressService.getDeliveryExpressListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(DeliveryExpressConvert.INSTANCE.convertList1(list));
    }

    @GetMapping("/page")
    @Operation(summary = "GetCourierpage.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:query')")
    public CommonResult<PageResult<DeliveryExpressRespVO>> getDeliveryExpressPage(@Valid DeliveryExpressPageReqVO pageVO) {
        PageResult<DeliveryExpressDO> pageResult = deliveryExpressService.getDeliveryExpressPage(pageVO);
        return success(DeliveryExpressConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "ExportCourier Excel.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDeliveryExpressExcel(@Valid DeliveryExpressExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DeliveryExpressDO> list = deliveryExpressService.getDeliveryExpressList(exportReqVO);
        // Export Excel
        List<DeliveryExpressExcelVO> dataList = DeliveryExpressConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "Carriers.xls", "Data", DeliveryExpressExcelVO.class, dataList);
    }
}
