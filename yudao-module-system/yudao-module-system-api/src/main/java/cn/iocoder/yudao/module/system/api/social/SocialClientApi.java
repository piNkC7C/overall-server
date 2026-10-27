package cn.iocoder.yudao.module.system.api.social;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.social.dto.*;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - social app.")
public interface SocialClientApi {

    String PREFIX = ApiConstants.PREFIX + "/social-client";

    @GetMapping(PREFIX + "/get-authorize-url")
    @Operation(summary = "Get the social-platform authorize URL.")
    @Parameters({
            @Parameter(name = "socialType", description = "Social platform type", example = "1", required = true),
            @Parameter(name = "userType", description = "User type.", example = "1", required = true),
            @Parameter(name = "redirectUri", description = "Redirect URL.", example = "https://www.iocoder.cn", required = true)
    })
    CommonResult<String> getAuthorizeUrl(@RequestParam("socialType") Integer socialType,
                                         @RequestParam("userType") Integer userType,
                                         @RequestParam("redirectUri") String redirectUri);

    @GetMapping(PREFIX + "/create-wx-mp-jsapi-signature")
    @Operation(summary = "Create WeChat official account JS SDK init signature.")
    @Parameters({
            @Parameter(name = "userType", description = "User type.", example = "1", required = true),
            @Parameter(name = "url", description = "Access URL.", example = "https://www.iocoder.cn", required = true)
    })
    CommonResult<SocialWxJsapiSignatureRespDTO> createWxMpJsapiSignature(@RequestParam("userType") Integer userType,
                                                                         @RequestParam("url") String url);

    @GetMapping(PREFIX + "/create-wx-ma-phone-number-info")
    @Operation(summary = "Get WeChat mini program phone info.")
    @Parameters({
            @Parameter(name = "userType", description = "User type.", example = "1", required = true),
            @Parameter(name = "phoneCode", description = "MobileAuthorization code.", example = "yudao11", required = true)
    })
    CommonResult<SocialWxPhoneNumberInfoRespDTO> getWxMaPhoneNumberInfo(@RequestParam("userType") Integer userType,
                                                                        @RequestParam("phoneCode") String phoneCode);

    @GetMapping(PREFIX + "/get-wxa-qrcode")
    @Operation(summary = "Getmini programQR Code.")
    CommonResult<byte[]> getWxaQrcode(@SpringQueryMap SocialWxQrcodeReqDTO reqVO);

    @GetMapping(PREFIX + "/get-wxa-subscribe-template-list")
    @Operation(summary = "Get WeChat mini program subscribe template.")
    CommonResult<List<SocialWxaSubscribeTemplateRespDTO>> getWxaSubscribeTemplateList(@RequestParam("userType") Integer userType);

    @PostMapping(PREFIX + "/send-wxa-subscribe-message")
    @Operation(summary = "Send WeChat mini program subscribe message.")
    CommonResult<Boolean> sendWxaSubscribeMessage(@Valid @RequestBody SocialWxaSubscribeMessageSendReqDTO reqDTO);

    /**
     * 上传订单发货到微信小程序
     *
     * @param userType 用户类型
     * @param reqDTO 请求
     */
    @PostMapping(PREFIX + "/upload-wxa-order-shipping-info")
    @Operation(summary = "Upload order shipment to the WeChat mini program.")
    CommonResult<Boolean> uploadWxaOrderShippingInfo(@RequestParam("userType") Integer userType,
                                                     @Valid @RequestBody SocialWxaOrderUploadShippingInfoReqDTO reqDTO);

    @PostMapping(PREFIX + "/notify-wxa-order-confirm-receive")
    @Operation(summary = "Notify the WeChat mini program that the order was received.")
    CommonResult<Boolean>  notifyWxaOrderConfirmReceive(@RequestParam("userType") Integer userType,
                                                        @Valid @RequestBody SocialWxaOrderNotifyConfirmReceiveReqDTO reqDTO);

}
