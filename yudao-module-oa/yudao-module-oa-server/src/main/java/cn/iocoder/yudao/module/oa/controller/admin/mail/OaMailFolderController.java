package cn.iocoder.yudao.module.oa.controller.admin.mail;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message.OaMailFolderRespVO;
import cn.iocoder.yudao.module.oa.service.mail.OaMailMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - enterprise email folder.")
@RestController
@RequestMapping("/oa/mail-folder")
@Validated
public class OaMailFolderController {

    @Resource
    private OaMailMessageService mailMessageService;

    @GetMapping("/list")
    @Operation(summary = "Get email folder list.")
    @Parameter(name = "accountId", description = "Email account code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:mail-account:query')")
    public CommonResult<List<OaMailFolderRespVO>> getMailFolderList(
            @RequestParam Long accountId) {
        return success(mailMessageService.getMailFolderList(accountId, getLoginUserId()));
    }

}
