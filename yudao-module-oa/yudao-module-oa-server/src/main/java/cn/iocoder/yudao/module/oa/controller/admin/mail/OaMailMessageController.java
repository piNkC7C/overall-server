package cn.iocoder.yudao.module.oa.controller.admin.mail;

import cn.iocoder.yudao.framework.common.pojo.*;
import cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message.*;
import cn.iocoder.yudao.module.oa.dal.dataobject.mail.*;
import cn.iocoder.yudao.module.oa.service.mail.OaMailMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import cn.hutool.core.lang.Pair;
import cn.iocoder.yudao.framework.common.util.servlet.ServletUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.oa.enums.mail.OaMailComposeModeEnum;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - enterprise email.")
@RestController
@RequestMapping("/oa/mail-message")
@Validated
@PreAuthorize("@ss.hasPermission('oa:mail-account:query')")
public class OaMailMessageController {

    @Resource
    private OaMailMessageService mailMessageService;

    @GetMapping("/compose")
    @Operation(summary = "Get compose prefills.")
    @Parameter(name = "id", description = "Email code.", required = true, example = "1024")
    @Parameter(name = "mode", description = "Compose mode.", required = true)
    public CommonResult<OaMailMessageSaveReqVO> getMailMessageCompose(@RequestParam Long id,
                                                                      @RequestParam @InEnum(value = OaMailComposeModeEnum.class, message = "Compose mode must be {value}.") String mode) {
        return success(mailMessageService.getMailMessageCompose(id, mode, getLoginUserId()));
    }

    @PostMapping("/sync")
    @Operation(summary = "Sync my email index.")
    @Parameter(name = "accountId", description = "Email account code.", required = true, example = "1024")
    public CommonResult<Integer> syncMailMessageList(@RequestParam Long accountId) {
        return success(mailMessageService.syncMailMessageList(accountId, getLoginUserId()));
    }

    @GetMapping("/page")
    @Operation(summary = "Get email index page.")
    public CommonResult<PageResult<OaMailMessageRespVO>> getMailMessagePage(@Valid OaMailMessagePageReqVO reqVO) {
        PageResult<OaMailMessageDO> pageResult = mailMessageService.getMailMessagePage(reqVO, getLoginUserId());
        return success(BeanUtils.toBean(pageResult, OaMailMessageRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "Get email details.")
    @Parameter(name = "id", description = "Email code.", required = true, example = "1024")
    public CommonResult<OaMailMessageRespVO> getMailMessage(@RequestParam Long id) {
        OaMailMessageDO message = mailMessageService.getMailMessage(id, getLoginUserId());
        return success(BeanUtils.toBean(message, OaMailMessageRespVO.class)
                .setAttachments(BeanUtils.toBean(message.getAttachments(), OaMailMessageRespVO.Attachment.class)));
    }

    @PutMapping("/update-read")
    @Operation(summary = "Update email Read status.")
    @Parameter(name = "id", description = "Email code.", required = true, example = "1024")
    @Parameter(name = "readStatus", description = "Is not Read.", required = true)
    public CommonResult<Boolean> updateMailMessageRead(@RequestParam Long id,
                                                       @RequestParam Boolean readStatus) {
        mailMessageService.updateMailMessageRead(id, readStatus, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete email.")
    @Parameter(name = "id", description = "Email code.", required = true, example = "1024")
    public CommonResult<Boolean> deleteMailMessage(@RequestParam Long id) {
        mailMessageService.deleteMailMessage(id, getLoginUserId());
        return success(true);
    }

    @PutMapping("/restore")
    @Operation(summary = "Restore the email to the inbox.")
    @Parameter(name = "id", description = "Email code.", required = true, example = "1024")
    public CommonResult<Boolean> restoreMailMessage(@RequestParam Long id) {
        mailMessageService.restoreMailMessage(id, getLoginUserId());
        return success(true);
    }

    @PostMapping(value = "/save-draft", consumes = "application/json")
    @Operation(summary = "Save draft.")
    public CommonResult<Long> saveMailMessageDraft(@Valid @RequestBody OaMailMessageSaveReqVO reqVO) {
        return success(mailMessageService.saveMailMessageDraft(reqVO, getLoginUserId()));
    }

    @PostMapping(value = "/send", consumes = "application/json")
    @Operation(summary = "Send email.")
    public CommonResult<String> sendMailMessage(@Valid @RequestBody OaMailMessageSaveReqVO reqVO) {
        return success(mailMessageService.sendMailMessage(reqVO, getLoginUserId()));
    }

    @PostMapping(value = "/save-draft", consumes = "multipart/form-data")
    @Operation(summary = "Save draft with attachments.")
    public CommonResult<Long> saveMailMessageDraftWithFiles(@Valid @RequestPart("data") OaMailMessageSaveReqVO reqVO,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        return success(mailMessageService.saveMailMessageDraft(reqVO.setFiles(files), getLoginUserId()));
    }

    @PostMapping(value = "/send", consumes = "multipart/form-data")
    @Operation(summary = "Send email with attachments.")
    public CommonResult<String> sendMailMessageWithFiles(@Valid @RequestPart("data") OaMailMessageSaveReqVO reqVO,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        return success(mailMessageService.sendMailMessage(reqVO.setFiles(files), getLoginUserId()));
    }

    @GetMapping("/attachment")
    @Operation(summary = "Download my email attachment.")
    public void getMailMessageAttachment(@RequestParam Long id, @RequestParam String part,
                                        HttpServletResponse response) throws IOException {
        Pair<String, byte[]> attachment = mailMessageService.getMailMessageAttachment(id, part, getLoginUserId());
        ServletUtils.writeAttachment(response, attachment.getKey(), attachment.getValue());
    }

}
