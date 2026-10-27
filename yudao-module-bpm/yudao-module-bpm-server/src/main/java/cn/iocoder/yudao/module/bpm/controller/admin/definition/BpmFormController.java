package cn.iocoder.yudao.module.bpm.controller.admin.definition;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmFormDO;
import cn.iocoder.yudao.module.bpm.service.definition.BpmFormService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - dynamic form.")
@RestController
@RequestMapping("/bpm/form")
@Validated
public class BpmFormController {

    @Resource
    private BpmFormService formService;

    @PostMapping("/create")
    @Operation(summary = "Createdynamic form.")
    @PreAuthorize("@ss.hasPermission('bpm:form:create')")
    public CommonResult<Long> createForm(@Valid @RequestBody BpmFormSaveReqVO createReqVO) {
        return success(formService.createForm(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedynamic form.")
    @PreAuthorize("@ss.hasPermission('bpm:form:update')")
    public CommonResult<Boolean> updateForm(@Valid @RequestBody BpmFormSaveReqVO updateReqVO) {
        formService.updateForm(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedynamic form.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:form:delete')")
    public CommonResult<Boolean> deleteForm(@RequestParam("id") Long id) {
        formService.deleteForm(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get dynamic form.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:form:query')")
    public CommonResult<BpmFormRespVO> getForm(@RequestParam("id") Long id) {
        BpmFormDO form = formService.getForm(id);
        return success(BeanUtils.toBean(form, BpmFormRespVO.class));
    }

    @GetMapping({"/list-all-simple", "/simple-list"})
    @Operation(summary = "Get dynamic form simple list.", description = "Used for form dropdowns.")
    public CommonResult<List<BpmFormRespVO>> getFormSimpleList() {
        List<BpmFormDO> list = formService.getFormList();
        return success(convertList(list, formDO -> // 只返回 id、name 字段
                new BpmFormRespVO().setId(formDO.getId()).setName(formDO.getName())));
    }

    @GetMapping("/page")
    @Operation(summary = "Get dynamic form page.")
    @PreAuthorize("@ss.hasPermission('bpm:form:query')")
    public CommonResult<PageResult<BpmFormRespVO>> getFormPage(@Valid BpmFormPageReqVO pageVO) {
        PageResult<BpmFormDO> pageResult = formService.getFormPage(pageVO);
        return success(BeanUtils.toBean(pageResult, BpmFormRespVO.class));
    }

}
