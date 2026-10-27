package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type.MesDvMachineryTypeListReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type.MesDvMachineryTypeRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo.type.MesDvMachineryTypeSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.machinery.MesDvMachineryTypeDO;
import cn.iocoder.yudao.module.mes.service.dv.machinery.MesDvMachineryTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - MES device type.")
@RestController
@RequestMapping("/mes/dv/machinery-type")
@Validated
public class MesDvMachineryTypeController {

    @Resource
    private MesDvMachineryTypeService machineryTypeService;

    @PostMapping("/create")
    @Operation(summary = "Createdevice type.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery-type:create')")
    public CommonResult<Long> createMachineryType(@Valid @RequestBody MesDvMachineryTypeSaveReqVO createReqVO) {
        return success(machineryTypeService.createMachineryType(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedevice type.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery-type:update')")
    public CommonResult<Boolean> updateMachineryType(@Valid @RequestBody MesDvMachineryTypeSaveReqVO updateReqVO) {
        machineryTypeService.updateMachineryType(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedevice type.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery-type:delete')")
    public CommonResult<Boolean> deleteMachineryType(@RequestParam("id") Long id) {
        machineryTypeService.deleteMachineryType(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device type.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery-type:query')")
    public CommonResult<MesDvMachineryTypeRespVO> getMachineryType(@RequestParam("id") Long id) {
        MesDvMachineryTypeDO machineryType = machineryTypeService.getMachineryType(id);
        return success(BeanUtils.toBean(machineryType, MesDvMachineryTypeRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get device type list.")
    @PreAuthorize("@ss.hasPermission('mes:dv-machinery-type:query')")
    public CommonResult<List<MesDvMachineryTypeRespVO>> getMachineryTypeList(@Valid MesDvMachineryTypeListReqVO listReqVO) {
        List<MesDvMachineryTypeDO> list = machineryTypeService.getMachineryTypeList(listReqVO);
        return success(BeanUtils.toBean(list, MesDvMachineryTypeRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get device type simple list.", description = "Only enabled type. Used for dropdowns.")
    public CommonResult<List<MesDvMachineryTypeRespVO>> getMachineryTypeSimpleList() {
        List<MesDvMachineryTypeDO> list = machineryTypeService.getMachineryTypeList(
                new MesDvMachineryTypeListReqVO().setStatus(CommonStatusEnum.ENABLE.getStatus()));
        return success(convertList(list, machineryType -> new MesDvMachineryTypeRespVO()
                .setId(machineryType.getId()).setName(machineryType.getName()).setParentId(machineryType.getParentId())
                .setCode(machineryType.getCode()).setRemark(machineryType.getRemark())));
    }

}
