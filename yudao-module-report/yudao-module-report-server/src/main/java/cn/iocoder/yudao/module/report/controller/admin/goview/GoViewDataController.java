package cn.iocoder.yudao.module.report.controller.admin.goview;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.report.controller.admin.goview.vo.data.GoViewDataGetBySqlReqVO;
import cn.iocoder.yudao.module.report.controller.admin.goview.vo.data.GoViewDataRespVO;
import cn.iocoder.yudao.module.report.service.goview.GoViewDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import java.util.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - GoView data.", description = "Provides SQL, HTTP, and other query capabilities.")
@RestController
@RequestMapping("/report/go-view/data")
@Validated
public class GoViewDataController {

    @Resource
    private GoViewDataService goViewDataService;

    @RequestMapping("/get-by-sql")
    @Operation(summary = "Used SQL search data.")
    @PreAuthorize("@ss.hasPermission('report:go-view-data:get-by-sql')")
    public CommonResult<GoViewDataRespVO> getDataBySQL(@Valid @RequestBody GoViewDataGetBySqlReqVO reqVO) {
        return success(goViewDataService.getDataBySQL(reqVO.getSql()));
    }

    @RequestMapping("/get-by-http")
    @Operation(summary = "Used HTTP search data.", description = "Sample API. Each query should have its own API.")
    @PreAuthorize("@ss.hasPermission('report:go-view-data:get-by-http')")
    public CommonResult<GoViewDataRespVO> getDataByHttp(
            @RequestParam(required = false) Map<String, String> params,
            @RequestBody(required = false) String body) { // params、body 按照需要去接收，这里仅仅是示例
        GoViewDataRespVO respVO = new GoViewDataRespVO();
        // 1. data Dimension
        respVO.setDimensions(Arrays.asList("Date", "PV", "UV")); // PV 是每天访问次数；UV 是每天访问人数
        // 2. detail data list
        // 目前通过随机的方式生成。一般来说，这里你可以写逻辑来实现数据的返回
        respVO.setSource(new LinkedList<>());
        for (int i = 1; i <= 12; i++) {
            String date = "2021-" + (i < 10 ? "0" + i : i);
            Integer pv = RandomUtil.randomInt(1000, 10000);
            Integer uv = RandomUtil.randomInt(100, 1000);
            respVO.getSource().add(MapUtil.<String, Object>builder().put("Date", date)
                    .put("PV", pv).put("UV", uv).build());
        }
        return success(respVO);
    }

}
