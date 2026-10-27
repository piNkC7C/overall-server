package cn.iocoder.yudao.module.system.controller.admin.user;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.system.controller.admin.user.vo.user.*;
import cn.iocoder.yudao.module.system.convert.user.UserConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import cn.iocoder.yudao.module.system.enums.common.SexEnum;
import cn.iocoder.yudao.module.system.service.dept.DeptService;
import cn.iocoder.yudao.module.system.service.user.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.Collections;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - user.")
@RestController
@RequestMapping("/system/user")
@Validated
public class UserController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;

    @PostMapping("/create")
    @Operation(summary = "Create user.")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Long> createUser(@Valid @RequestBody UserSaveReqVO reqVO) {
        Long id = userService.createUser(reqVO);
        return success(id);
    }

    @PutMapping("update")
    @Operation(summary = "Edit user.")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateUser(@Valid @RequestBody UserSaveReqVO reqVO) {
        userService.updateUser(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteuser.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "Code list.", required = true)
    @Operation(summary = "Batch deleteuser.")
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteUserList(@RequestParam("ids") List<Long> ids) {
        userService.deleteUserList(ids);
        return success(true);
    }

    @PutMapping("/update-password")
    @Operation(summary = "Reset user password.")
    @PreAuthorize("@ss.hasPermission('system:user:update-password')")
    public CommonResult<Boolean> updateUserPassword(@Valid @RequestBody UserUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(reqVO.getId(), reqVO.getPassword());
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Edit user status.")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateUserStatus(@Valid @RequestBody UserUpdateStatusReqVO reqVO) {
        userService.updateUserStatus(reqVO.getId(), reqVO.getStatus());
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "Get user page list.")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<UserRespVO>> getUserPage(@Valid UserPageReqVO pageReqVO) {
        // Get user page list
        PageResult<AdminUserDO> pageResult = userService.getUserPage(pageReqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal()));
        }
        // 拼接数据
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(
                convertList(pageResult.getList(), AdminUserDO::getDeptId));
        return success(new PageResult<>(UserConvert.INSTANCE.convertList(pageResult.getList(), deptMap),
                pageResult.getTotal()));
    }

    @GetMapping("/list")
    @Operation(summary = "Get user details list.")
    @Parameter(name = "ids", description = "Code list.", required = true, example = "[1024]")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<UserRespVO>> getUserList(@RequestParam("ids") List<Long> ids) {
        List<AdminUserDO> list = userService.getUserList(ids);
        if (CollUtil.isEmpty(list)) {
            return success(Collections.emptyList());
        }
        // 拼接数据
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(convertSet(list, AdminUserDO::getDeptId));
        return success(UserConvert.INSTANCE.convertList(list, deptMap));
    }

    @GetMapping({"/list-all-simple", "/simple-list"})
    @Operation(summary = "Get user simple info list.", description = "Only enabled user. Used for dropdowns.")
    public CommonResult<List<UserSimpleRespVO>> getSimpleUserList(
            @RequestParam(value = "deptId", required = false) Long deptId) {
        List<AdminUserDO> list = userService.getUserListByStatus(
                CommonStatusEnum.ENABLE.getStatus(), deptId);

        // 拼接数据
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(
                convertList(list, AdminUserDO::getDeptId));
        return success(UserConvert.INSTANCE.convertSimpleList(list, deptMap));
    }

    @GetMapping("/get")
    @Operation(summary = "Get user details.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<UserRespVO> getUser(@RequestParam("id") Long id) {
        AdminUserDO user = userService.getUser(id);
        if (user == null) {
            return success(null);
        }
        // 拼接数据
        DeptDO dept = deptService.getDept(user.getDeptId());
        return success(UserConvert.INSTANCE.convert(user, dept));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportuser.")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportUserList(@Validated UserPageReqVO exportReqVO,
                               HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<AdminUserDO> list = userService.getUserPage(exportReqVO).getList();
        // 输出 Excel
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(
                convertList(list, AdminUserDO::getDeptId));
        ExcelUtils.write(response, "Users.xls", "Data", UserRespVO.class,
                UserConvert.INSTANCE.convertList(list, deptMap));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get importusertemplate.")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<UserImportExcelVO> list = Arrays.asList(
                UserImportExcelVO.builder().username("jdoe").deptId(1L).email("jdoe@example.com").mobile("15555550100")
                        .nickname("Jane Doe").status(CommonStatusEnum.ENABLE.getStatus()).sex(SexEnum.MALE.getSex()).build(),
                UserImportExcelVO.builder().username("asmith").deptId(2L).email("asmith@example.com").mobile("15555550101")
                        .nickname("Alex Smith").status(CommonStatusEnum.DISABLE.getStatus()).sex(SexEnum.FEMALE.getSex()).build()
        );
        // 输出
        ExcelUtils.write(response, "User Import Template.xls", "Users", UserImportExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "Importuser.")
    @Parameters({
            @Parameter(name = "file", description = "Excel file.", required = true),
            @Parameter(name = "updateSupport", description = "Is not support update, default is false.", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('system:user:import')")
    public CommonResult<UserImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                      @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport) throws Exception {
        List<UserImportExcelVO> list = ExcelUtils.read(file, UserImportExcelVO.class);
        return success(userService.importUserList(list, updateSupport));
    }

    // ==================== 免鉴权接口（用于 IM 点头像弹名片、加好友搜索等场景） ====================

    @GetMapping("/get-simple")
    @Operation(summary = "Get user simple info.", description = "Used when opening a profile card from an avatar. No auth required.")
    @Parameter(name = "id", description = "User ID.", required = true, example = "1024")
    public CommonResult<UserSimpleRespVO> getSimpleUser(@RequestParam("id") Long id) {
        AdminUserDO user = userService.getUser(id);
        if (user == null) {
            return success(null);
        }
        // 拼接数据
        DeptDO dept = user.getDeptId() != null ? deptService.getDept(user.getDeptId()) : null;
        Map<Long, DeptDO> deptMap = dept != null ? Collections.singletonMap(dept.getId(), dept) : Collections.emptyMap();
        return success(CollUtil.getFirst(UserConvert.INSTANCE.convertSimpleList(
                Collections.singletonList(user), deptMap)));
    }

    @GetMapping("/list-by-nickname")
    @Operation(summary = "By nickname fuzzy search user simple info.", description = "Used when adding friends. No auth required. Currently matches nickname only.")
    @Parameter(name = "nickname", description = "NicknameKeyword.", required = true, example = "Overall.")
    public CommonResult<List<UserSimpleRespVO>> getSimpleUserListByNickname(@RequestParam("nickname") String nickname) {
        if (StrUtil.isBlank(nickname)) {
            return success(Collections.emptyList());
        }
        // 拼接数据
        List<AdminUserDO> list = userService.getUserListByNickname(nickname.trim());
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(convertList(list, AdminUserDO::getDeptId));
        return success(UserConvert.INSTANCE.convertSimpleList(list, deptMap));
    }

}
