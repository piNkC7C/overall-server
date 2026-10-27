package cn.iocoder.yudao.module.iot.controller.admin.device;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.iot.controller.admin.device.vo.device.*;
import cn.iocoder.yudao.module.iot.dal.dataobject.device.IotDeviceDO;
import cn.iocoder.yudao.module.iot.dal.dataobject.product.IotProductDO;
import cn.iocoder.yudao.module.iot.service.device.IotDeviceService;
import cn.iocoder.yudao.module.iot.service.product.IotProductService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

@Tag(name = "Admin - IoT device.")
@RestController
@RequestMapping("/iot/device")
@Validated
public class IotDeviceController {

    @Resource
    private IotDeviceService deviceService;
    @Resource
    private IotProductService productService;

    @PostMapping("/create")
    @Operation(summary = "Createdevice.")
    @PreAuthorize("@ss.hasPermission('iot:device:create')")
    public CommonResult<Long> createDevice(@Valid @RequestBody IotDeviceSaveReqVO createReqVO) {
        return success(deviceService.createDevice(createReqVO));
    }


    @PutMapping("/update")
    @Operation(summary = "Updatedevice.")
    @PreAuthorize("@ss.hasPermission('iot:device:update')")
    public CommonResult<Boolean> updateDevice(@Valid @RequestBody IotDeviceSaveReqVO updateReqVO) {
        deviceService.updateDevice(updateReqVO);
        return success(true);
    }

    @PutMapping("/bind-gateway")
    @Operation(summary = "Bind child device to gateway.")
    @PreAuthorize("@ss.hasPermission('iot:device:update')")
    public CommonResult<Boolean> bindDeviceGateway(@Valid @RequestBody IotDeviceBindGatewayReqVO reqVO) {
        deviceService.bindDeviceGateway(reqVO.getSubIds(), reqVO.getGatewayId());
        return success(true);
    }

    @PutMapping("/unbind-gateway")
    @Operation(summary = "Unbind child device and gateway.")
    @PreAuthorize("@ss.hasPermission('iot:device:update')")
    public CommonResult<Boolean> unbindDeviceGateway(@Valid @RequestBody IotDeviceUnbindGatewayReqVO reqVO) {
        deviceService.unbindDeviceGateway(reqVO.getSubIds(), reqVO.getGatewayId());
        return success(true);
    }

    @GetMapping("/sub-device-list")
    @Operation(summary = "Get gateway child device list.")
    @Parameter(name = "gatewayId", description = "Gateway device code.", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<List<IotDeviceRespVO>> getSubDeviceList(@RequestParam("gatewayId") Long gatewayId) {
        List<IotDeviceDO> list = deviceService.getDeviceListByGatewayId(gatewayId);
        if (CollUtil.isEmpty(list)) {
            return success(Collections.emptyList());
        }

        // 补充产品名称
        Map<Long, IotProductDO> productMap = convertMap(productService.getProductList(), IotProductDO::getId);
        return success(convertList(list, device -> {
            IotDeviceRespVO respVO = BeanUtils.toBean(device, IotDeviceRespVO.class);
            MapUtils.findAndThen(productMap, device.getProductId(),
                    product -> respVO.setProductName(product.getName()));
            return respVO;
        }));
    }

    @GetMapping("/unbound-sub-device-page")
    @Operation(summary = "Get not bind gateway child device page.")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<PageResult<IotDeviceRespVO>> getUnboundSubDevicePage(@Valid IotDevicePageReqVO pageReqVO) {
        PageResult<IotDeviceDO> pageResult = deviceService.getUnboundSubDevicePage(pageReqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        // 补充产品名称
        Map<Long, IotProductDO> productMap = convertMap(productService.getProductList(), IotProductDO::getId);
        PageResult<IotDeviceRespVO> result = BeanUtils.toBean(pageResult, IotDeviceRespVO.class, device ->
                MapUtils.findAndThen(productMap, device.getProductId(), product -> device.setProductName(product.getName())));
        return success(result);
    }

    @PutMapping("/update-group")
    @Operation(summary = "Updatedevice group.")
    @PreAuthorize("@ss.hasPermission('iot:device:update')")
    public CommonResult<Boolean> updateDeviceGroup(@Valid @RequestBody IotDeviceUpdateGroupReqVO updateReqVO) {
        deviceService.updateDeviceGroup(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete order device.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:device:delete')")
    public CommonResult<Boolean> deleteDevice(@RequestParam("id") Long id) {
        deviceService.deleteDevice(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Delete multiple devices.")
    @Parameter(name = "ids", description = "ID list.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:device:delete')")
    public CommonResult<Boolean> deleteDeviceList(@RequestParam("ids") Collection<Long> ids) {
        deviceService.deleteDeviceList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<IotDeviceRespVO> getDevice(@RequestParam("id") Long id) {
        IotDeviceDO device = deviceService.getDevice(id);
        return success(BeanUtils.toBean(device, IotDeviceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get device page.")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<PageResult<IotDeviceRespVO>> getDevicePage(@Valid IotDevicePageReqVO pageReqVO) {
        PageResult<IotDeviceDO> pageResult = deviceService.getDevicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotDeviceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportdevice Excel.")
    @PreAuthorize("@ss.hasPermission('iot:device:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDeviceExcel(@Valid IotDevicePageReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        CommonResult<PageResult<IotDeviceRespVO>> result = getDevicePage(exportReqVO);
        // Export Excel
        ExcelUtils.write(response, "Devices.xls", "Data", IotDeviceRespVO.class,
                result.getData().getList());
    }

    @GetMapping("/count")
    @Operation(summary = "Get device quantity.")
    @Parameter(name = "productId", description = "Product code.", example = "1")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<Long> getDeviceCount(@RequestParam("productId") Long productId) {
        return success(deviceService.getDeviceCountByProductId(productId));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get device simple info list.", description = "Used by frontend select options.")
    @Parameters({
            @Parameter(name = "deviceType", description = "Device type.", example = "1"),
            @Parameter(name = "productId", description = "Product code.", example = "1024")
    })
    public CommonResult<List<IotDeviceRespVO>> getDeviceSimpleList(
            @RequestParam(value = "deviceType", required = false) Integer deviceType,
            @RequestParam(value = "productId", required = false) Long productId) {
        List<IotDeviceDO> list = deviceService.getDeviceListByCondition(deviceType, productId);
        return success(convertList(list, device ->  // 只返回 id、name、productId 字段
                new IotDeviceRespVO().setId(device.getId()).setDeviceName(device.getDeviceName())
                        .setProductId(device.getProductId()).setState(device.getState())));
    }

    @GetMapping("/location-list")
    @Operation(summary = "Get deviceLocation list.", description = "Devices with coordinates. Used on the map.")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<List<IotDeviceRespVO>> getDeviceLocationList() {
        // 1. get has Location info device list
        List<IotDeviceDO> devices = deviceService.getDeviceListByHasLocation();
        if (CollUtil.isEmpty(devices)) {
            return success(Collections.emptyList());
        }

        // 2. 转换并返回
        Map<Long, IotProductDO> productMap = convertMap(productService.getProductList(), IotProductDO::getId);
        return success(convertList(devices, device -> {
            IotDeviceRespVO respVO = BeanUtils.toBean(device, IotDeviceRespVO.class);
            MapUtils.findAndThen(productMap, device.getProductId(),
                    product -> respVO.setProductName(product.getName()));
            return respVO;
        }));
    }

    @PostMapping("/import")
    @Operation(summary = "Importdevice.")
    @PreAuthorize("@ss.hasPermission('iot:device:import')")
    public CommonResult<IotDeviceImportRespVO> importDevice(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport)
            throws Exception {
        List<IotDeviceImportExcelVO> list = ExcelUtils.read(file, IotDeviceImportExcelVO.class);
        return success(deviceService.importDevice(list, updateSupport));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get importdevicetemplate.")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<IotDeviceImportExcelVO> list = Arrays.asList(
                IotDeviceImportExcelVO.builder().deviceName("temp-sensor-001").parentDeviceName("gateway110")
                        .productKey("1de24640dfe").groupNames("canary,production").build(),
                IotDeviceImportExcelVO.builder().deviceName("biubiu").productKey("YzvHxd4r67sT4s2B")
                        .groupNames("").build());
        // 输出
        ExcelUtils.write(response, "Device Import Template.xls", "Data", IotDeviceImportExcelVO.class, list);
    }

    @GetMapping("/get-auth-info")
    @Operation(summary = "Get device connect info.")
    @PreAuthorize("@ss.hasPermission('iot:device:auth-info')")
    public CommonResult<IotDeviceAuthInfoRespVO> getDeviceAuthInfo(@RequestParam("id") Long id) {
        return success(deviceService.getDeviceAuthInfo(id));
    }

    // TODO @haohao：可以使用 @RequestParam("productKey") String productKey, @RequestParam("deviceNames") List<String> deviceNames 来接收哇？
    @GetMapping("/list-by-product-key-and-names")
    @Operation(summary = "Via product key and device name list get device.")
    @PreAuthorize("@ss.hasPermission('iot:device:query')")
    public CommonResult<List<IotDeviceRespVO>> getDevicesByProductKeyAndNames(@Valid IotDeviceByProductKeyAndNamesReqVO reqVO) {
        List<IotDeviceDO> devices = deviceService.getDeviceListByProductKeyAndNames(reqVO.getProductKey(), reqVO.getDeviceNames());
        return success(BeanUtils.toBean(devices, IotDeviceRespVO.class));
    }

}
