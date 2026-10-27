package cn.iocoder.yudao.module.mp.controller.admin.news;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.framework.common.util.object.PageUtils;
import cn.iocoder.yudao.module.mp.controller.admin.news.vo.MpFreePublishPageReqVO;
import cn.iocoder.yudao.module.mp.dal.dataobject.material.MpMaterialDO;
import cn.iocoder.yudao.module.mp.framework.mp.core.MpServiceFactory;
import cn.iocoder.yudao.module.mp.service.material.MpMaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.freepublish.WxMpFreePublishItem;
import me.chanjar.weixin.mp.bean.freepublish.WxMpFreePublishList;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.module.mp.enums.ErrorCodeConstants.*;

@Tag(name = "Admin - official account publishing.")
@RestController
@RequestMapping("/mp/free-publish")
@Validated
public class MpFreePublishController {

    @Resource
    private MpServiceFactory mpServiceFactory;

    @Resource
    private MpMaterialService mpMaterialService;

    @GetMapping("/page")
    @Operation(summary = "Get published articles page.")
    @PreAuthorize("@ss.hasPermission('mp:free-publish:query')")
    public CommonResult<PageResult<WxMpFreePublishItem>> getFreePublishPage(MpFreePublishPageReqVO reqVO) {
        // 从公众号查询已发布的图文列表
        WxMpService mpService = mpServiceFactory.getRequiredMpService(reqVO.getAccountId());
        WxMpFreePublishList publicationRecords;
        try {
            publicationRecords = mpService.getFreePublishService().getPublicationRecords(
                    PageUtils.getStart(reqVO), reqVO.getPageSize());
        } catch (WxErrorException e) {
            throw exception(FREE_PUBLISH_LIST_FAIL, e.getError().getErrorMsg());
        }
        // 查询对应的图片地址。目的：解决公众号的图片链接无法在我们后台展示
        setFreePublishThumbUrl(publicationRecords.getItems());

        // 返回分页
        return success(new PageResult<>(publicationRecords.getItems(), publicationRecords.getTotalCount().longValue()));
    }

    private void setFreePublishThumbUrl(List<WxMpFreePublishItem> items) {
        // 1.1 get mediaId Array
        Set<String> mediaIds = new HashSet<>();
        items.forEach(item -> item.getContent().getNewsItem().forEach(newsItem -> mediaIds.add(newsItem.getThumbMediaId())));
        if (CollUtil.isEmpty(mediaIds)) {
            return;
        }
        // 1.2 batch search a matching Media media
        Map<String, MpMaterialDO> materials = CollectionUtils.convertMap(mpMaterialService.getMaterialListByMediaId(mediaIds),
                MpMaterialDO::getMediaId);

        // 2. 设置回 WxMpFreePublishItem 记录
        items.forEach(item -> item.getContent().getNewsItem().forEach(newsItem ->
                findAndThen(materials, newsItem.getThumbMediaId(), material -> newsItem.setThumbUrl(material.getUrl()))));
    }

    @PostMapping("/submit")
    @Operation(summary = "Publish draft.")
    @Parameters({
            @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "1024"),
            @Parameter(name = "mediaId", description = "Need Publish draft media_id.", required = true, example = "2048")
    })
    @PreAuthorize("@ss.hasPermission('mp:free-publish:submit')")
    public CommonResult<String> submitFreePublish(@RequestParam("accountId") Long accountId,
                                                  @RequestParam("mediaId") String mediaId) {
        WxMpService mpService = mpServiceFactory.getRequiredMpService(accountId);
        try {
            String publishId = mpService.getFreePublishService().submit(mediaId);
            return success(publishId);
        } catch (WxErrorException e) {
            throw exception(FREE_PUBLISH_SUBMIT_FAIL, e.getError().getErrorMsg());
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete draft.")
    @Parameters({
            @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "1024"),
            @Parameter(name = "articleId", description = "Publishrecord code.", required = true, example = "2048")
    })
    @PreAuthorize("@ss.hasPermission('mp:free-publish:delete')")
    public CommonResult<Boolean> deleteFreePublish(@RequestParam("accountId") Long accountId,
                                                   @RequestParam("articleId") String articleId) {
        WxMpService mpService = mpServiceFactory.getRequiredMpService(accountId);
        try {
            mpService.getFreePublishService().deletePushAllArticle(articleId);
            return success(true);
        } catch (WxErrorException e) {
            throw exception(FREE_PUBLISH_DELETE_FAIL, e.getError().getErrorMsg());
        }
    }

}
