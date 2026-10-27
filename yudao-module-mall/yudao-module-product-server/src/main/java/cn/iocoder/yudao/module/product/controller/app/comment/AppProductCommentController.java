package cn.iocoder.yudao.module.product.controller.app.comment;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.product.controller.app.comment.vo.AppCommentPageReqVO;
import cn.iocoder.yudao.module.product.controller.app.comment.vo.AppProductCommentRespVO;
import cn.iocoder.yudao.module.product.dal.dataobject.comment.ProductCommentDO;
import cn.iocoder.yudao.module.product.service.comment.ProductCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "User APP - product review.")
@RestController
@RequestMapping("/product/comment")
@Validated
public class AppProductCommentController {

    @Resource
    private ProductCommentService productCommentService;

    @GetMapping("/page")
    @Operation(summary = "Get product review page.")
    @PermitAll
    public CommonResult<PageResult<AppProductCommentRespVO>> getCommentPage(@Valid AppCommentPageReqVO pageVO) {
        // Search comment page
        PageResult<ProductCommentDO> pageResult = productCommentService.getCommentPage(pageVO, Boolean.TRUE);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }

        // 拼接返回
        pageResult.getList().forEach(item -> {
            if (Boolean.TRUE.equals(item.getAnonymous())) {
                item.setUserNickname(ProductCommentDO.NICKNAME_ANONYMOUS);
            }
        });
        return success(BeanUtils.toBean(pageResult, AppProductCommentRespVO.class));
    }

}
