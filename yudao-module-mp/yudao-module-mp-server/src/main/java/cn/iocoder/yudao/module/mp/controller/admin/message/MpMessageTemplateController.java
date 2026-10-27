package cn.iocoder.yudao.module.mp.controller.admin.message;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mp.controller.admin.message.vo.template.MpMessageTemplateListReqVO;
import cn.iocoder.yudao.module.mp.controller.admin.message.vo.template.MpMessageTemplateRespVO;
import cn.iocoder.yudao.module.mp.controller.admin.message.vo.template.MpMessageTemplateSendReqVO;
import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageTemplateDO;
import cn.iocoder.yudao.module.mp.service.message.MpMessageTemplateService;
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

@Tag(name = "Admin - Official Accounttemplatemessage.")
@RestController
@RequestMapping("/mp/message-template")
@Validated
public class MpMessageTemplateController {

    @Resource
    private MpMessageTemplateService messageTemplateService;

    @DeleteMapping("/delete")
    @Operation(summary = "Deletetemplatemessage.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:message-template:delete')")
    public CommonResult<Boolean> deleteMessageTemplate(@RequestParam("id") Long id) {
        messageTemplateService.deleteMessageTemplate(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get templatemessage.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mp:message-template:query')")
    public CommonResult<MpMessageTemplateRespVO> getMessageTemplate(@RequestParam("id") Long id) {
        MpMessageTemplateDO msgTemplate = messageTemplateService.getMessageTemplate(id);
        return success(BeanUtils.toBean(msgTemplate, MpMessageTemplateRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get templatemessage list.")
    @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "2048")
    @PreAuthorize("@ss.hasPermission('mp:message-template:query')")
    public CommonResult<List<MpMessageTemplateRespVO>> getMessageTemplateList(MpMessageTemplateListReqVO listReqVO) {
        List<MpMessageTemplateDO> list = messageTemplateService.getMessageTemplateList(listReqVO);
        return success(BeanUtils.toBean(list, MpMessageTemplateRespVO.class));
    }

    @PostMapping("/sync")
    @Operation(summary = "Sync Official Accounttemplate.")
    @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "2048")
    @PreAuthorize("@ss.hasPermission('mp:message-template:sync')")
    public CommonResult<Boolean> syncMessageTemplate(@RequestParam("accountId") Long accountId) {
        messageTemplateService.syncMessageTemplate(accountId);
        return success(true);
    }

    @PostMapping("/send")
    @Operation(summary = "Send a template message to followers.")
    @PreAuthorize("@ss.hasPermission('mp:message-template:send')")
    public CommonResult<Boolean> sendMessageTemplate(@Valid @RequestBody MpMessageTemplateSendReqVO sendReqVO) {
        messageTemplateService.sendMessageTempalte(sendReqVO);
        return success(true);
    }

}