package cn.iocoder.yudao.module.pms.controller.admin.kb.recycle;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo.PmsKnowledgeRecycleDetailRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo.PmsKnowledgeRecyclePreviewRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo.PmsKnowledgeRecycleRespVO;
import cn.iocoder.yudao.module.pms.dal.dataobject.kb.content.PmsKnowledgeDocumentDO;
import cn.iocoder.yudao.module.pms.dal.dataobject.kb.recycle.PmsKnowledgeRecycleRecordDO;
import cn.iocoder.yudao.module.pms.enums.kb.PmsKnowledgeObjectTypeEnum;
import cn.iocoder.yudao.module.pms.service.kb.content.PmsKnowledgeDocumentService;
import cn.iocoder.yudao.module.pms.service.kb.recycle.PmsKnowledgeRecycleService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - PMS knowledge base recycle bin.")
@RestController
@RequestMapping("/pms/kb/recycle")
@Validated
public class PmsKnowledgeRecycleController {

    @Resource
    private PmsKnowledgeRecycleService recycleService;

    @Resource
    private AdminUserApi adminUserApi;

    @Resource
    private PmsKnowledgeDocumentService documentService;

    @GetMapping("/library-list")
    @Operation(summary = "Get already delete knowledge base list.")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<List<PmsKnowledgeRecycleRespVO>> getLibraryRecycleList() {
        List<PmsKnowledgeRecycleRecordDO> records = recycleService.getLibraryRecycleList(getLoginUserId());
        return success(buildRecycleRespVOList(records));
    }

    @GetMapping("/content-list")
    @Operation(summary = "Get knowledge base last delete content.")
    @Parameter(name = "libraryId", description = "Knowledge base code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<List<PmsKnowledgeRecycleRespVO>> getContentRecycleList(
            @RequestParam("libraryId") Long libraryId) {
        List<PmsKnowledgeRecycleRecordDO> records = recycleService.getContentRecycleList(
                libraryId, getLoginUserId());
        return success(buildRecycleRespVOList(records));
    }

    @GetMapping("/content-detail")
    @Operation(summary = "Getknowledge baserecentdeletedetails.")
    @Parameter(name = "id", description = "Recycle bin record code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<PmsKnowledgeRecycleDetailRespVO> getContentRecycleDetail(
            @RequestParam("id") Long id) {
        return success(recycleService.getContentRecycleDetail(id, getLoginUserId()));
    }

    @GetMapping("/content-preview")
    @Operation(summary = "Preview knowledge base last delete content.")
    @Parameter(name = "id", description = "Recycle bin record code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<PmsKnowledgeRecyclePreviewRespVO> getContentRecyclePreview(
            @RequestParam("id") Long id,
            @RequestParam(value = "entityId", required = false) Long entityId) {
        PmsKnowledgeDocumentDO document = recycleService.getContentRecyclePreview(id, entityId, getLoginUserId());
        return success(BeanUtils.toBean(document, PmsKnowledgeRecyclePreviewRespVO.class,
                o -> o.setName(document.getTitle())));
    }

    @PutMapping("/restore")
    @Operation(summary = "Restore recycle bin object.")
    @Parameter(name = "id", description = "Recycle bin record code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<Boolean> restoreContentRecycle(@RequestParam("id") Long id) {
        recycleService.restoreContentRecycle(id, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/permanent-delete")
    @Operation(summary = "Permanently delete recycle bin object.")
    @Parameter(name = "id", description = "Recycle bin record code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:delete')")
    public CommonResult<Boolean> deleteContentRecycle(@RequestParam("id") Long id) {
        recycleService.deleteContentRecycle(id, getLoginUserId());
        return success(true);
    }

    // ==================== 拼接 VO ====================

    private List<PmsKnowledgeRecycleRespVO> buildRecycleRespVOList(List<PmsKnowledgeRecycleRecordDO> records) {
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(records, PmsKnowledgeRecycleRecordDO::getDeleteUserId));
        Map<Long, PmsKnowledgeDocumentDO> documentMap = documentService.getDocumentMap(convertSet(records, record ->
                PmsKnowledgeObjectTypeEnum.FILE.getType().equals(record.getType()) ? record.getEntityId() : null));
        return convertList(records, record -> {
            PmsKnowledgeRecycleRespVO recordVO = BeanUtils.toBean(record, PmsKnowledgeRecycleRespVO.class);
            findAndThen(documentMap, record.getEntityId(), document -> recordVO.setFileSize(document.getFileSize()));
            findAndThen(userMap, record.getDeleteUserId(), user -> recordVO.setDeleteUserName(user.getNickname()));
            return recordVO;
        });
    }

}
