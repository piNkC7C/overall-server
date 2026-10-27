package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.MesWmBarcodePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.MesWmBarcodeRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.MesWmBarcodeSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.wm.barcode.MesWmBarcodeDO;
import cn.iocoder.yudao.module.mes.service.wm.barcode.MesWmBarcodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES barcode list.")
@RestController
@RequestMapping("/mes/wm/barcode")
@Validated
public class MesWmBarcodeController {

    @Resource
    private MesWmBarcodeService barcodeService;

    @PostMapping("/create")
    @Operation(summary = "Createbarcode.")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:create')")
    public CommonResult<Long> createBarcode(@Valid @RequestBody MesWmBarcodeSaveReqVO createReqVO) {
        return success(barcodeService.createBarcode(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatebarcode.")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:update')")
    public CommonResult<Boolean> updateBarcode(@Valid @RequestBody MesWmBarcodeSaveReqVO updateReqVO) {
        barcodeService.updateBarcode(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletebarcode.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:delete')")
    public CommonResult<Boolean> deleteBarcode(@RequestParam("id") Long id) {
        barcodeService.deleteBarcode(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get barcode.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:query')")
    public CommonResult<MesWmBarcodeRespVO> getBarcode(@RequestParam("id") Long id) {
        MesWmBarcodeDO barcode = barcodeService.getBarcode(id);
        return success(BeanUtils.toBean(barcode, MesWmBarcodeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get barcode page.")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:query')")
    public CommonResult<PageResult<MesWmBarcodeRespVO>> getBarcodePage(@Valid MesWmBarcodePageReqVO pageReqVO) {
        PageResult<MesWmBarcodeDO> pageResult = barcodeService.getBarcodePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesWmBarcodeRespVO.class));
    }

    @GetMapping("/get-by-business")
    @Operation(summary = "By business object get barcode info.", description = "Frontend at createbarcodeImage.")
    @Parameter(name = "bizType", description = "Business type.", required = true, example = "102")
    @Parameter(name = "bizId", description = "Business code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:query')")
    public CommonResult<MesWmBarcodeRespVO> getBarcodeByBusiness(
            @RequestParam("bizType") Integer bizType,
            @RequestParam("bizId") Long bizId) {
        MesWmBarcodeDO barcode = barcodeService.getBarcodeByBizTypeAndBizId(bizType, bizId);
        return success(BeanUtils.toBean(barcode, MesWmBarcodeRespVO.class));
    }

    @GetMapping("/generate-content")
    @Operation(summary = "Createbarcode content.")
    @Parameter(name = "bizType", description = "Business type.", required = true, example = "1")
    @Parameter(name = "bizCode", description = "Business code.", required = true, example = "WO202403070001")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:query')")
    public CommonResult<String> generateBarcodeContent(@RequestParam("bizType") @NotNull(message = "Business type is required.") Integer bizType,
                                                        @RequestParam("bizCode") @NotBlank(message = "Business code is required.") String bizCode) {
        String content = barcodeService.generateBarcodeContent(bizType, bizCode);
        return success(content);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export barcode list Excel.")
    @PreAuthorize("@ss.hasPermission('mes:wm-barcode:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBarcodeExcel(@Valid MesWmBarcodePageReqVO pageReqVO,
                                   HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesWmBarcodeDO> list = barcodeService.getBarcodePage(pageReqVO).getList();
        List<MesWmBarcodeRespVO> voList = BeanUtils.toBean(list, MesWmBarcodeRespVO.class);
        ExcelUtils.write(response, "Barcodes.xls", "Data", MesWmBarcodeRespVO.class, voList);
    }

}
