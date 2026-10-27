package cn.iocoder.yudao.module.system.controller.admin.mail;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.mail.vo.template.*;
import cn.iocoder.yudao.module.system.dal.dataobject.mail.MailTemplateDO;
import cn.iocoder.yudao.module.system.service.mail.MailSendService;
import cn.iocoder.yudao.module.system.service.mail.MailTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - email template.")
@RestController
@RequestMapping("/system/mail-template")
public class MailTemplateController {

    @Resource
    private MailTemplateService mailTempleService;
    @Resource
    private MailSendService mailSendService;

    @PostMapping("/create")
    @Operation(summary = "Create email template.")
    @PreAuthorize("@ss.hasPermission('system:mail-template:create')")
    public CommonResult<Long> createMailTemplate(@Valid @RequestBody MailTemplateSaveReqVO createReqVO){
        return success(mailTempleService.createMailTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit email template.")
    @PreAuthorize("@ss.hasPermission('system:mail-template:update')")
    public CommonResult<Boolean> updateMailTemplate(@Valid @RequestBody MailTemplateSaveReqVO updateReqVO){
        mailTempleService.updateMailTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete email template.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:mail-template:delete')")
    public CommonResult<Boolean> deleteMailTemplate(@RequestParam("id") Long id) {
        mailTempleService.deleteMailTemplate(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Batch delete email template.")
    @Parameter(name = "ids", description = "Code list.", required = true)
    @PreAuthorize("@ss.hasPermission('system:mail-template:delete')")
    public CommonResult<Boolean> deleteMailTemplateList(@RequestParam("ids") List<Long> ids) {
        mailTempleService.deleteMailTemplateList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get email template.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:mail-template:query')")
    public CommonResult<MailTemplateRespVO> getMailTemplate(@RequestParam("id") Long id) {
        MailTemplateDO template = mailTempleService.getMailTemplate(id);
        return success(BeanUtils.toBean(template, MailTemplateRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get email template page.")
    @PreAuthorize("@ss.hasPermission('system:mail-template:query')")
    public CommonResult<PageResult<MailTemplateRespVO>> getMailTemplatePage(@Valid MailTemplatePageReqVO pageReqVO) {
        PageResult<MailTemplateDO> pageResult = mailTempleService.getMailTemplatePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MailTemplateRespVO.class));
    }

    @GetMapping({"/list-all-simple", "/simple-list"})
    @Operation(summary = "Get email template simple list.", description = "Only enabled email template. Used for dropdowns.")
    public CommonResult<List<MailTemplateSimpleRespVO>> getSimpleMailTemplateList() {
        List<MailTemplateDO> list = mailTempleService.getMailTemplateListByStatus(
                CommonStatusEnum.ENABLE.getStatus());
        return success(BeanUtils.toBean(list, MailTemplateSimpleRespVO.class));
    }

    @PostMapping("/send-mail")
    @Operation(summary = "Send SMS.")
    @PreAuthorize("@ss.hasPermission('system:mail-template:send-mail')")
    public CommonResult<Long> sendMail(@Valid @RequestBody MailTemplateSendReqVO sendReqVO) {
        return success(mailSendService.sendSingleMailToAdmin(getLoginUserId(),
                sendReqVO.getToMails(), sendReqVO.getCcMails(), sendReqVO.getBccMails(),
                sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
    }

}
