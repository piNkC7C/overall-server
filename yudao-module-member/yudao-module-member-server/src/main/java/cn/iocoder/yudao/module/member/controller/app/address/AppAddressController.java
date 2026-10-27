package cn.iocoder.yudao.module.member.controller.app.address;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.member.convert.address.AddressConvert;
import cn.iocoder.yudao.module.member.dal.dataobject.address.MemberAddressDO;
import cn.iocoder.yudao.module.member.service.address.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "App - user shipping address.")
@RestController
@RequestMapping("/member/address")
@Validated
public class AppAddressController {

    @Resource
    private AddressService addressService;

    @PostMapping("/create")
    @Operation(summary = "Createusershipping address.")
    public CommonResult<Long> createAddress(@Valid @RequestBody AppAddressCreateReqVO createReqVO) {
        return success(addressService.createAddress(getLoginUserId(), createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateusershipping address.")
    public CommonResult<Boolean> updateAddress(@Valid @RequestBody AppAddressUpdateReqVO updateReqVO) {
        addressService.updateAddress(getLoginUserId(), updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteusershipping address.")
    @Parameter(name = "id", description = "Code.", required = true)
    public CommonResult<Boolean> deleteAddress(@RequestParam("id") Long id) {
        addressService.deleteAddress(getLoginUserId(), id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Getusershipping address.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    public CommonResult<AppAddressRespVO> getAddress(@RequestParam("id") Long id) {
        MemberAddressDO address = addressService.getAddress(getLoginUserId(), id);
        return success(AddressConvert.INSTANCE.convert(address));
    }

    @GetMapping("/get-default")
    @Operation(summary = "Get default shipping address.")
    public CommonResult<AppAddressRespVO> getDefaultUserAddress() {
        MemberAddressDO address = addressService.getDefaultUserAddress(getLoginUserId());
        return success(AddressConvert.INSTANCE.convert(address));
    }

    @GetMapping("/list")
    @Operation(summary = "Getusershipping addresslist.")
    public CommonResult<List<AppAddressRespVO>> getAddressList() {
        List<MemberAddressDO> list = addressService.getAddressList(getLoginUserId());
        return success(AddressConvert.INSTANCE.convertList(list));
    }

}
