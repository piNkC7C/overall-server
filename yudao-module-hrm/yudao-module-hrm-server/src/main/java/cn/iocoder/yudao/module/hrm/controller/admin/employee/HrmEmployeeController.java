package cn.iocoder.yudao.module.hrm.controller.admin.employee;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.ip.core.utils.AreaUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord.HrmEmployeeConvertToFullTimeReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord.HrmEmployeeDemoteReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord.HrmEmployeePromoteReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord.HrmEmployeeRegularReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord.HrmEmployeeTransferReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeCancelQuitReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeConfirmEntryReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeCreateFromUserReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeDeptStatisticsRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeImportExcelVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeImportRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeListReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeePageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeNotifyRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeQuitReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeRehireReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeSaveReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee.HrmEmployeeStatusCountRespVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.info.HrmEmployeeDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.employment.HrmEmployeeSalaryCardDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.insurance.employee.HrmInsuranceEmployeeInfoDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.recruit.config.HrmRecruitChannelDO;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeEntryStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusTabEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTypeEnum;
import cn.iocoder.yudao.module.hrm.service.employee.employment.HrmEmployeeSalaryCardService;
import cn.iocoder.yudao.module.hrm.service.employee.info.HrmEmployeeService;
import cn.iocoder.yudao.module.hrm.service.insurance.employee.HrmInsuranceEmployeeInfoService;
import cn.iocoder.yudao.module.hrm.service.recruit.config.HrmRecruitChannelService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.getFirst;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.sum;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.getYearsBetween;

@Tag(name = "Admin - HRM employee profile.")
@RestController
@RequestMapping("/hrm/employee")
@Validated
public class HrmEmployeeController {

    @Resource
    private HrmEmployeeService employeeService;
    @Resource
    private HrmRecruitChannelService recruitChannelService;
    @Resource
    private HrmInsuranceEmployeeInfoService insuranceEmployeeInfoService;
    @Resource
    private HrmEmployeeSalaryCardService employeeSalaryCardService;

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private DeptApi deptApi;

    @PostMapping("/create")
    @Operation(summary = "Createemployee profile.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:create')")
    public CommonResult<Long> createEmployee(@Valid @RequestBody HrmEmployeeSaveReqVO createReqVO) {
        return success(employeeService.createEmployee(createReqVO));
    }

    @PostMapping("/create-list")
    @Operation(summary = "Bulk-create from admin users without a profile employee profile.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:create')")
    public CommonResult<List<Long>> createEmployeeList(
            @RequestBody @NotEmpty(message = "Employees to create cannot be empty.")
            @Size(max = 100, message = "You can create at most 100 employees at a time.")
            List<@Valid HrmEmployeeCreateFromUserReqVO> createReqVOList) {
        return success(employeeService.createEmployeeList(createReqVOList));
    }

    @GetMapping("/bound-user-id-list")
    @Operation(summary = "Get admin user IDs that already have an employee profile list.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:create')")
    public CommonResult<List<Long>> getBoundUserIdList() {
        return success(employeeService.getBoundUserIdList());
    }

    @PostMapping("/send-profile-fill-message")
    @Operation(summary = "Send enter employee profile notification.")
    @Parameter(name = "ids", description = "Employee ID list.", required = true, example = "1024,1025")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<HrmEmployeeNotifyRespVO> sendEmployeeProfileFillMessage(
            @RequestParam("ids") @NotEmpty(message = "Employee is required.")
            @Size(max = 100, message = "You can notify at most 100 employees at a time.") List<Long> ids) {
        return success(employeeService.sendEmployeeProfileFillMessage(ids));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateemployee profile.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> updateEmployee(@Valid @RequestBody HrmEmployeeSaveReqVO updateReqVO) {
        employeeService.updateEmployee(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteemployee profile.")
    @Parameter(name = "id", description = "Employee profile code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:employee:delete')")
    public CommonResult<Boolean> deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Batch deleteemployee profile.")
    @Parameter(name = "ids", description = "Employee profile ID list.", required = true, example = "1024,1025")
    @PreAuthorize("@ss.hasPermission('hrm:employee:delete')")
    public CommonResult<Boolean> deleteEmployeeList(@RequestParam("ids") @NotEmpty List<Long> ids) {
        employeeService.deleteEmployeeList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get employee profile.")
    @Parameter(name = "id", description = "Employee profile code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<HrmEmployeeRespVO> getEmployee(@RequestParam("id") Long id) {
        return success(buildEmployeeRespVO(employeeService.getEmployee(id)));
    }

    @PutMapping("/confirm-entry")
    @Operation(summary = "Confirm employeeOnboarding.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> confirmEmployeeEntry(@Valid @RequestBody HrmEmployeeConfirmEntryReqVO reqVO) {
        employeeService.confirmEmployeeEntry(reqVO);
        return success(true);
    }

    @PostMapping("/rehire")
    @Operation(summary = "Handle offboarding employee again Onboarding.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> rehireEmployee(@Valid @RequestBody HrmEmployeeRehireReqVO reqVO) {
        employeeService.rehireEmployee(reqVO);
        return success(true);
    }

    @PostMapping("/regular")
    @Operation(summary = "Handleemployee confirmation.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> regularEmployee(@Valid @RequestBody HrmEmployeeRegularReqVO reqVO) {
        employeeService.regularEmployee(reqVO);
        return success(true);
    }

    @PostMapping("/transfer")
    @Operation(summary = "Process employee job transfer.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> transferEmployee(@Valid @RequestBody HrmEmployeeTransferReqVO reqVO) {
        employeeService.transferEmployee(reqVO);
        return success(true);
    }

    @PostMapping("/promote")
    @Operation(summary = "HandleemployeePromotion.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> promoteEmployee(@Valid @RequestBody HrmEmployeePromoteReqVO reqVO) {
        employeeService.promoteEmployee(reqVO);
        return success(true);
    }

    @PostMapping("/demote")
    @Operation(summary = "HandleemployeeDemotion.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> demoteEmployee(@Valid @RequestBody HrmEmployeeDemoteReqVO reqVO) {
        employeeService.demoteEmployee(reqVO);
        return success(true);
    }

    @PostMapping("/convert-to-full-time")
    @Operation(summary = "HandleemployeeConvert to Full-time.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> convertEmployeeToFullTime(
            @Valid @RequestBody HrmEmployeeConvertToFullTimeReqVO reqVO) {
        employeeService.convertEmployeeToFullTime(reqVO);
        return success(true);
    }

    @PostMapping("/quit")
    @Operation(summary = "Handleemployee offboarding.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> quitEmployee(@Valid @RequestBody HrmEmployeeQuitReqVO reqVO) {
        employeeService.quitEmployee(reqVO);
        return success(true);
    }

    @PutMapping("/cancel-quit")
    @Operation(summary = "Cancelemployee offboarding.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> cancelEmployeeQuit(@Valid @RequestBody HrmEmployeeCancelQuitReqVO reqVO) {
        employeeService.cancelEmployeeQuit(reqVO);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "Get employee profile page.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<PageResult<HrmEmployeeRespVO>> getEmployeePage(@Validated HrmEmployeePageReqVO pageReqVO) {
        PageResult<HrmEmployeeDO> pageResult = employeeService.getEmployeePage(pageReqVO);
        return success(new PageResult<>(buildEmployeeRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list")
    @Operation(summary = "Get employee list.", description = "Used to show selected employees on the form.")
    @Parameter(name = "ids", description = "Employee code list.", required = true, example = "[1024]")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<List<HrmEmployeeRespVO>> getEmployeeList(@RequestParam("ids") @NotEmpty List<Long> ids) {
        return success(buildEmployeeRespVOList(employeeService.getEmployeeListByIds(ids)));
    }

    @GetMapping("/simple-page")
    @Operation(summary = "Get employee simple page.", description = "Returns only non-sensitive fields needed by the employee picker.")
    public CommonResult<PageResult<HrmEmployeeRespVO>> getEmployeeSimplePage(
            @Validated HrmEmployeePageReqVO pageReqVO) {
        PageResult<HrmEmployeeDO> pageResult = employeeService.getEmployeePage(pageReqVO);
        return success(new PageResult<>(buildEmployeeSimpleRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get employee simple list.", description = "Used to show selected employees in the employee picker.")
    @Parameter(name = "ids", description = "Employee code list.", required = true, example = "[1024]")
    public CommonResult<List<HrmEmployeeRespVO>> getEmployeeSimpleList(
            @RequestParam("ids") @NotEmpty List<Long> ids) {
        return success(buildEmployeeSimpleRespVOList(employeeService.getEmployeeListByIds(ids)));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportemployee profile.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:export')")
    @ApiAccessLog(operateType = OperateTypeEnum.EXPORT)
    public void exportEmployee(@Validated HrmEmployeePageReqVO exportReqVO,
                               HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<HrmEmployeeRespVO> list = buildEmployeeExportRespVOList(employeeService.getEmployeeList(
                BeanUtils.toBean(exportReqVO, HrmEmployeeListReqVO.class)));
        ExcelUtils.write(response, "Employee Records.xlsx", "Data", HrmEmployeeRespVO.class, list);
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "Get employee profile importtemplate.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:import')")
    @ApiAccessLog(operateType = OperateTypeEnum.EXPORT)
    public void importTemplate(HttpServletResponse response) throws IOException {
        List<HrmEmployeeImportExcelVO> list = Collections.singletonList(
                HrmEmployeeImportExcelVO.builder()
                        .name("Jane Doe").jobNumber("HRM001").mobile("15555550100")
                        .country("United States").nation("American").idType(5).idNumber("OTHER-19900101")
                        .sex(1).email("hrm@example.com").nativePlace("Austin, TX")
                        .birthday(LocalDateTime.of(1990, 1, 1, 0, 0))
                        .address("100 Main St, Austin, TX").highestEducation(8)
                        .deptId(1L).leaderJobNumber("HRM000")
                        .postName("Software Engineer").postLevel("P6")
                        .entryStatus(HrmEmployeeEntryStatusEnum.ACTIVE.getStatus())
                        .status(HrmEmployeeStatusEnum.REGULAR.getStatus())
                        .type(HrmEmployeeTypeEnum.FORMAL.getType()).probation(3)
                        .entryTime(LocalDateTime.of(2026, 7, 9, 9, 0))
                        .regularTime(LocalDateTime.of(2026, 10, 9, 9, 0))
                        .workCity("Austin").workAddress("Downtown").workDetailAddress("100 Congress Ave")
                        .companyAgeStartTime(LocalDateTime.of(2026, 7, 9, 9, 0))
                        .userMobile("15555550101")
                        .bankCardNumber("4111111111111111").bankAreaId(330100).bankName("Example Bank")
                        .bankBranchName("Austin Downtown").firstSocialSecurity(false)
                        .firstAccumulationFund(false).socialSecurityNumber("SB20260001")
                        .accumulationFundNumber("GJJ20260001")
                        .socialSecurityStartMonth(LocalDateTime.of(2026, 7, 1, 0, 0))
                        .schemeName("Standard Benefits Plan")
                        .remark("Sample employee").build()
        );
        ExcelUtils.write(response, "Employee Import Template.xlsx", "Employees", HrmEmployeeImportExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "Importemployee profile.")
    @Parameters({
            @Parameter(name = "file", description = "Excel file.", required = true),
            @Parameter(name = "duplicateStrategy", description = "Duplicate employee policy: 1 skip, 2 overwrite, 3 fail.", example = "3")
    })
    @PreAuthorize("@ss.hasPermission('hrm:employee:import')")
    @ApiAccessLog(operateType = OperateTypeEnum.IMPORT)
    public CommonResult<HrmEmployeeImportRespVO> importExcel(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "duplicateStrategy", required = false, defaultValue = "3") Integer duplicateStrategy)
            throws Exception {
        List<HrmEmployeeImportExcelVO> list = ExcelUtils.read(file, HrmEmployeeImportExcelVO.class);
        return success(employeeService.importEmployeeList(list, duplicateStrategy));
    }

    @GetMapping("/status-count")
    @Operation(summary = "Get employee statusStats.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<List<HrmEmployeeStatusCountRespVO>> getEmployeeStatusCount(
            @Validated HrmEmployeePageReqVO pageReqVO) {
        Map<Integer, Long> countMap = employeeService.getEmployeeStatusCount(pageReqVO);
        return success(convertList(Arrays.asList(HrmEmployeeStatusTabEnum.values()),
                status -> new HrmEmployeeStatusCountRespVO(status.getStatus(),
                        countMap.getOrDefault(status.getStatus(), 0L))));
    }

    @GetMapping("/dept-statistics")
    @Operation(summary = "Get employeedepartmentStats.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<List<HrmEmployeeDeptStatisticsRespVO>> getEmployeeDeptStatistics() {
        Map<Long, Map<Integer, Long>> countMap = employeeService.getEmployeeCountMapByDeptAndType();
        return success(convertList(countMap.entrySet(), entry -> {
            Map<Integer, Long> typeCountMap = entry.getValue();
            long activeCount = sum(typeCountMap.values(), Long::longValue);
            return new HrmEmployeeDeptStatisticsRespVO(entry.getKey(), activeCount,
                    typeCountMap.getOrDefault(HrmEmployeeTypeEnum.FORMAL.getType(), 0L),
                    typeCountMap.getOrDefault(HrmEmployeeTypeEnum.INFORMAL.getType(), 0L));
        }));
    }

    // ==================== 拼接 VO ====================

    private HrmEmployeeRespVO buildEmployeeRespVO(HrmEmployeeDO employee) {
        if (employee == null) {
            return null;
        }
        return getFirst(buildEmployeeRespVOList(Collections.singletonList(employee)));
    }

    private List<HrmEmployeeRespVO> buildEmployeeRespVOList(List<HrmEmployeeDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1.1 后台用户信息
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, HrmEmployeeDO::getUserId));
        // 1.2 department info
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(list, HrmEmployeeDO::getDeptId));
        // 1.3 Direct Manageremployee info
        Map<Long, HrmEmployeeDO> leaderEmployeeMap = employeeService.getEmployeeMap(
                convertSet(list, HrmEmployeeDO::getLeaderEmployeeId));
        // 1.4 Recruiting Channel info
        Map<Long, HrmRecruitChannelDO> channelMap = recruitChannelService.getRecruitChannelMap(
                convertSet(list, HrmEmployeeDO::getChannelId));
        // 1.5 工资卡和社保资料
        Set<Long> employeeIds = convertSet(list, HrmEmployeeDO::getId);
        Map<Long, HrmEmployeeSalaryCardDO> salaryCardMap =
                employeeSalaryCardService.getSalaryCardMap(employeeIds);
        Map<Long, HrmInsuranceEmployeeInfoDO> insuranceEmployeeInfoMap =
                insuranceEmployeeInfoService.getInsuranceEmployeeInfoMap(employeeIds);

        // 2. 拼接响应
        LocalDate today = LocalDate.now();
        return BeanUtils.toBean(list, HrmEmployeeRespVO.class, vo -> {
            MapUtils.findAndThen(userMap, vo.getUserId(), user -> vo.setUserNickname(user.getNickname()));
            MapUtils.findAndThen(deptMap, vo.getDeptId(), dept -> vo.setDeptName(dept.getName()));
            MapUtils.findAndThen(leaderEmployeeMap, vo.getLeaderEmployeeId(),
                    leader -> vo.setLeaderEmployeeName(leader.getName()));
            MapUtils.findAndThen(channelMap, vo.getChannelId(),
                    channel -> vo.setChannelName(channel.getName()));
            MapUtils.findAndThen(salaryCardMap, vo.getId(), salaryCard -> vo
                    .setSalaryCardNumber(salaryCard.getBankCardNumber())
                    .setSalaryCardAreaId(salaryCard.getBankAreaId())
                    .setSalaryCardAreaName(AreaUtils.format(salaryCard.getBankAreaId()))
                    .setSalaryCardBankName(salaryCard.getBankName())
                    .setSalaryCardBankBranchName(salaryCard.getBankBranchName()));
            MapUtils.findAndThen(insuranceEmployeeInfoMap, vo.getId(), socialSecurity -> vo
                    .setSocialSecurityNumber(socialSecurity.getSocialSecurityNumber())
                    .setAccumulationFundNumber(socialSecurity.getAccumulationFundNumber()));
            if (vo.getBirthday() != null) {
                vo.setAge(getYearsBetween(vo.getBirthday().toLocalDate(), today));
            }
            if (vo.getCompanyAgeStartTime() != null) {
                vo.setCompanyAge(getYearsBetween(vo.getCompanyAgeStartTime().toLocalDate(), today));
            }
        });
    }

    private List<HrmEmployeeRespVO> buildEmployeeSimpleRespVOList(List<HrmEmployeeDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. searchdepartment and Direct Manager info
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(list, HrmEmployeeDO::getDeptId));
        Map<Long, HrmEmployeeDO> leaderEmployeeMap = employeeService.getEmployeeMap(
                convertSet(list, HrmEmployeeDO::getLeaderEmployeeId));

        // 2. 拼接精简响应
        return convertList(list, employee -> {
            HrmEmployeeRespVO vo = new HrmEmployeeRespVO()
                    .setId(employee.getId()).setName(employee.getName())
                    .setJobNumber(employee.getJobNumber()).setMobile(employee.getMobile())
                    .setDeptId(employee.getDeptId()).setLeaderEmployeeId(employee.getLeaderEmployeeId())
                    .setPostName(employee.getPostName()).setPostLevel(employee.getPostLevel())
                    .setEntryStatus(employee.getEntryStatus()).setStatus(employee.getStatus());
            MapUtils.findAndThen(deptMap, employee.getDeptId(), dept -> vo.setDeptName(dept.getName()));
            MapUtils.findAndThen(leaderEmployeeMap, employee.getLeaderEmployeeId(),
                    leader -> vo.setLeaderEmployeeName(leader.getName()));
            return vo;
        });
    }

    private List<HrmEmployeeRespVO> buildEmployeeExportRespVOList(List<HrmEmployeeDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. 查询导出展示信息，不加载工资卡和社保等敏感聚合
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertSet(list, HrmEmployeeDO::getUserId));
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(list, HrmEmployeeDO::getDeptId));
        Map<Long, HrmEmployeeDO> leaderEmployeeMap = employeeService.getEmployeeMap(
                convertSet(list, HrmEmployeeDO::getLeaderEmployeeId));
        Map<Long, HrmRecruitChannelDO> channelMap = recruitChannelService.getRecruitChannelMap(
                convertSet(list, HrmEmployeeDO::getChannelId));

        // 2. 拼接安全导出字段
        return convertList(list, employee -> {
            HrmEmployeeRespVO vo = new HrmEmployeeRespVO()
                    .setId(employee.getId()).setName(employee.getName())
                    .setJobNumber(employee.getJobNumber()).setMobile(employee.getMobile())
                    .setPostName(employee.getPostName()).setPostLevel(employee.getPostLevel())
                    .setEntryStatus(employee.getEntryStatus()).setStatus(employee.getStatus()).setType(employee.getType())
                    .setEntryTime(employee.getEntryTime()).setRegularTime(employee.getRegularTime())
                    .setLeaveTime(employee.getLeaveTime())
                    .setWorkCity(employee.getWorkCity()).setWorkAddress(employee.getWorkAddress());
            MapUtils.findAndThen(userMap, employee.getUserId(), user -> vo.setUserNickname(user.getNickname()));
            MapUtils.findAndThen(deptMap, employee.getDeptId(), dept -> vo.setDeptName(dept.getName()));
            MapUtils.findAndThen(leaderEmployeeMap, employee.getLeaderEmployeeId(),
                    leader -> vo.setLeaderEmployeeName(leader.getName()));
            MapUtils.findAndThen(channelMap, employee.getChannelId(), channel -> vo.setChannelName(channel.getName()));
            return vo;
        });
    }

}
