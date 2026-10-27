package cn.iocoder.yudao.module.pay.controller.admin.refund;

import cn.hutool.core.collection.CollectionUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.*;
import cn.iocoder.yudao.module.pay.convert.refund.PayRefundConvert;
import cn.iocoder.yudao.module.pay.dal.dataobject.app.PayAppDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.refund.PayRefundDO;
import cn.iocoder.yudao.module.pay.service.app.PayAppService;
import cn.iocoder.yudao.module.pay.service.refund.PayRefundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - refund.")
@RestController
@RequestMapping("/pay/refund")
@Validated
public class PayRefundController {

    @Resource
    private PayRefundService refundService;
    @Resource
    private PayAppService appService;

    @GetMapping("/get")
    @Operation(summary = "Get refund.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:refund:query')")
    public CommonResult<PayRefundDetailsRespVO> getRefund(@RequestParam("id") Long id) {
        PayRefundDO refund = refundService.getRefund(id);
        if (refund == null) {
            return success(new PayRefundDetailsRespVO());
        }

        // 拼接数据
        PayAppDO app = appService.getApp(refund.getAppId());
        return success(PayRefundConvert.INSTANCE.convert(refund, app));
    }

    @GetMapping("/page")
    @Operation(summary = "Get refund page.")
    @PreAuthorize("@ss.hasPermission('pay:refund:query')")
    public CommonResult<PageResult<PayRefundPageItemRespVO>> getRefundPage(@Valid PayRefundPageReqVO pageVO) {
        PageResult<PayRefundDO> pageResult = refundService.getRefundPage(pageVO);
        if (CollectionUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal()));
        }

        // Process appID data
        Map<Long, PayAppDO> appMap = appService.getAppMap(convertList(pageResult.getList(), PayRefundDO::getAppId));
        return success(PayRefundConvert.INSTANCE.convertPage(pageResult, appMap));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportrefund Excel.")
    @PreAuthorize("@ss.hasPermission('pay:refund:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRefundExcel(@Valid PayRefundExportReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        List<PayRefundDO> list = refundService.getRefundList(exportReqVO);

        // 拼接返回
        Map<Long, PayAppDO> appMap = appService.getAppMap(convertList(list, PayRefundDO::getAppId));
        List<PayRefundExcelVO> excelList = PayRefundConvert.INSTANCE.convertList(list, appMap);
        // Export Excel
        ExcelUtils.write(response, "Refund Orders.xls", "Data", PayRefundExcelVO.class, excelList);
    }

}
