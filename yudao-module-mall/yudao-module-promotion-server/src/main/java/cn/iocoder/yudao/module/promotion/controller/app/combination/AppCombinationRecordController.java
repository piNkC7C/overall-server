package cn.iocoder.yudao.module.promotion.controller.app.combination;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record.AppCombinationRecordDetailRespVO;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record.AppCombinationRecordPageReqVO;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record.AppCombinationRecordRespVO;
import cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record.AppCombinationRecordSummaryRespVO;
import cn.iocoder.yudao.module.promotion.convert.combination.CombinationActivityConvert;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationRecordDO;
import cn.iocoder.yudao.module.promotion.service.combination.CombinationRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User APP - group buy campaign.")
@RestController
@RequestMapping("/promotion/combination-record")
@Validated
public class AppCombinationRecordController {

    @Resource
    private CombinationRecordService combinationRecordService;

    @GetMapping("/get-summary")
    @Operation(summary = "Get group-buy record summary.", description = "Used on the mini-program home page.")
    @PermitAll
    public CommonResult<AppCombinationRecordSummaryRespVO> getCombinationRecordSummary() {
        AppCombinationRecordSummaryRespVO summary = new AppCombinationRecordSummaryRespVO();
        // 1. 获得拼团参与用户数量
        Long userCount = combinationRecordService.getCombinationUserCount();
        if (userCount == 0) {
            summary.setAvatars(Collections.emptyList());
            summary.setUserCount(userCount);
            return success(summary);
        }
        summary.setUserCount(userCount);

        // 2. get group buy recordAvatar
        List<CombinationRecordDO> records = combinationRecordService.getLatestCombinationRecordList(
                AppCombinationRecordSummaryRespVO.AVATAR_COUNT);
        summary.setAvatars(convertList(records, CombinationRecordDO::getAvatar));
        return success(summary);
    }

    @GetMapping("/get-head-list")
    @Operation(summary = "Get the latest n group-buy records started by the leader.")
    @Parameters({
            @Parameter(name = "activityId", description = "Group buy campaign code."),
            @Parameter(name = "status", description = "Group buy status."), // Matching CombinationRecordStatusEnum enum
            @Parameter(name = "count", description = "Quantity.")
    })
    @PermitAll
    public CommonResult<List<AppCombinationRecordRespVO>> getHeadCombinationRecordList(
            @RequestParam(value = "activityId", required = false) Long activityId,
            @RequestParam("status") Integer status,
            @RequestParam(value = "count", defaultValue = "20") @Max(20) Integer count) {
        List<CombinationRecordDO> list = combinationRecordService.getHeadCombinationRecordList(activityId, status, count);
        return success(BeanUtils.toBean(list, AppCombinationRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Me group buy record page.")
    public CommonResult<PageResult<AppCombinationRecordRespVO>> getCombinationRecordPage(
            @Valid AppCombinationRecordPageReqVO pageReqVO) {
        PageResult<CombinationRecordDO> pageResult = combinationRecordService.getCombinationRecordPage(
                getLoginUserId(), pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppCombinationRecordRespVO.class));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "Get group buy recorddetail.")
    @Parameter(name = "id", description = "Group buy record code.", required = true, example = "1024")
    @PermitAll
    public CommonResult<AppCombinationRecordDetailRespVO> getCombinationRecordDetail(@RequestParam("id") Long id) {
        // 1. 查找这条拼团记录
        CombinationRecordDO record = combinationRecordService.getCombinationRecordById(id);
        if (record == null) {
            return success(null);
        }

        // 2. 查找该拼团的参团记录
        CombinationRecordDO headRecord;
        List<CombinationRecordDO> memberRecords;
        if (Objects.equals(record.getHeadId(), CombinationRecordDO.HEAD_ID_GROUP)) { // 情况一：团长
            headRecord = record;
            memberRecords = combinationRecordService.getCombinationRecordListByHeadId(record.getId());
        } else { // 情况二：团员
            headRecord = combinationRecordService.getCombinationRecordById(record.getHeadId());
            memberRecords = combinationRecordService.getCombinationRecordListByHeadId(headRecord.getId());
        }

        // 3. 拼接数据
        return success(CombinationActivityConvert.INSTANCE.convert(getLoginUserId(), headRecord, memberRecords));
    }

}
