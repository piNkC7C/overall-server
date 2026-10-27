package cn.iocoder.yudao.module.mes.controller.admin.md.workstation;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.worker.MesMdWorkstationWorkerRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.worker.MesMdWorkstationWorkerSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkstationWorkerDO;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkstationWorkerService;
import cn.iocoder.yudao.module.system.api.dept.PostApi;
import cn.iocoder.yudao.module.system.api.dept.dto.PostRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES labor resource.")
@RestController
@RequestMapping("/mes/md-workstation-worker")
@Validated
public class MesMdWorkstationWorkerController {

    @Resource
    private MesMdWorkstationWorkerService workstationWorkerService;

    @Resource
    private PostApi postApi;

    @PostMapping("/create")
    @Operation(summary = "Create labor resource.")
    @PreAuthorize("@ss.hasPermission('mes:md-workstation:update')")
    public CommonResult<Long> createWorkstationWorker(@Valid @RequestBody MesMdWorkstationWorkerSaveReqVO createReqVO) {
        return success(workstationWorkerService.createWorkstationWorker(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update labor resource.")
    @PreAuthorize("@ss.hasPermission('mes:md-workstation:update')")
    public CommonResult<Boolean> updateWorkstationWorker(@Valid @RequestBody MesMdWorkstationWorkerSaveReqVO updateReqVO) {
        workstationWorkerService.updateWorkstationWorker(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete labor resource.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-workstation:update')")
    public CommonResult<Boolean> deleteWorkstationWorker(@RequestParam("id") Long id) {
        workstationWorkerService.deleteWorkstationWorker(id);
        return success(true);
    }

    @GetMapping("/list-by-workstation")
    @Operation(summary = "Get labor resource list.")
    @Parameter(name = "workstationId", description = "Workstation code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-workstation:query')")
    public CommonResult<List<MesMdWorkstationWorkerRespVO>> getWorkstationWorkerList(
            @RequestParam("workstationId") Long workstationId) {
        List<MesMdWorkstationWorkerDO> list = workstationWorkerService.getWorkstationWorkerListByWorkstationId(workstationId);
        return success(buildWorkstationWorkerRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    private List<MesMdWorkstationWorkerRespVO> buildWorkstationWorkerRespVOList(List<MesMdWorkstationWorkerDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get post info
        Map<Long, PostRespDTO> postMap = postApi.getPostMap(
                convertSet(list, MesMdWorkstationWorkerDO::getPostId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesMdWorkstationWorkerRespVO.class, vo -> {
            MapUtils.findAndThen(postMap, vo.getPostId(),
                    post -> vo.setPostName(post.getName()));
        });
    }

}
