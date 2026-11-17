package cn.iocoder.yudao.module.system.api.permission;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.api.permission.dto.RoleRespDTO;
import cn.iocoder.yudao.module.system.controller.admin.permission.vo.role.RoleSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.permission.RoleDO;
import cn.iocoder.yudao.module.system.enums.permission.RoleTypeEnum;
import cn.iocoder.yudao.module.system.service.permission.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public CommonResult<Boolean> validRoleList(Collection<Long> ids) {
        roleService.validateRoleList(ids);
        return success(true);
    }

    @Override
    public CommonResult<RoleRespDTO> getRole(Long id) {
        RoleDO role = roleService.getRole(id);
        return success(BeanUtils.toBean(role, RoleRespDTO.class));
    }

    @Override
    public CommonResult<List<RoleRespDTO>> getRoleList(Collection<Long> ids) {
        List<RoleDO> list = roleService.getRoleList(ids);
        return success(BeanUtils.toBean(list, RoleRespDTO.class));
    }

    @Override
    public CommonResult<List<RoleRespDTO>> getRoleListByCodes(Collection<String> codes) {
        if (CollUtil.isEmpty(codes)) {
            return success(Collections.emptyList());
        }
        List<RoleDO> list = roleService.getRoleList().stream()
                .filter(role -> codes.contains(role.getCode()))
                .collect(Collectors.toList());
        return success(BeanUtils.toBean(list, RoleRespDTO.class));
    }

    @Override
    public CommonResult<RoleRespDTO> createRoleIfAbsent(String code, String name) {
        RoleDO existing = roleService.getRoleList().stream()
                .filter(role -> Objects.equals(code, role.getCode()))
                .findFirst().orElse(null);
        if (existing != null) {
            return success(BeanUtils.toBean(existing, RoleRespDTO.class));
        }
        RoleSaveReqVO createReqVO = new RoleSaveReqVO();
        createReqVO.setName(name);
        createReqVO.setCode(code);
        createReqVO.setSort(0);
        createReqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        createReqVO.setRemark("Auto created for CRM BPM");
        Long roleId = roleService.createRole(createReqVO, RoleTypeEnum.SYSTEM.getType());
        return success(BeanUtils.toBean(roleService.getRole(roleId), RoleRespDTO.class));
    }

}
