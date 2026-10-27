package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo.Demo03StudentErpPageReqVO;
import cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo.Demo03StudentErpRespVO;
import cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo.Demo03StudentErpSaveReqVO;
import cn.iocoder.yudao.module.infra.dal.dataobject.demo.demo03.Demo03CourseDO;
import cn.iocoder.yudao.module.infra.dal.dataobject.demo.demo03.Demo03GradeDO;
import cn.iocoder.yudao.module.infra.dal.dataobject.demo.demo03.Demo03StudentDO;
import cn.iocoder.yudao.module.infra.service.demo.demo03.erp.Demo03StudentErpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - student.")
@RestController
@RequestMapping("/infra/demo03-student-erp")
@Validated
public class Demo03StudentErpController {

    @Resource
    private Demo03StudentErpService demo03StudentErpService;

    @PostMapping("/create")
    @Operation(summary = "Createstudent.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:create')")
    public CommonResult<Long> createDemo03Student(@Valid @RequestBody Demo03StudentErpSaveReqVO createReqVO) {
        return success(demo03StudentErpService.createDemo03Student(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatestudent.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:update')")
    public CommonResult<Boolean> updateDemo03Student(@Valid @RequestBody Demo03StudentErpSaveReqVO updateReqVO) {
        demo03StudentErpService.updateDemo03Student(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletestudent.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03Student(@RequestParam("id") Long id) {
        demo03StudentErpService.deleteDemo03Student(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "Code.", required = true)
    @Operation(summary = "Bulk deletestudent.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03StudentList(@RequestParam("ids") List<Long> ids) {
        demo03StudentErpService.deleteDemo03StudentList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Getstudent.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<Demo03StudentErpRespVO> getDemo03Student(@RequestParam("id") Long id) {
        Demo03StudentDO demo03Student = demo03StudentErpService.getDemo03Student(id);
        return success(BeanUtils.toBean(demo03Student, Demo03StudentErpRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Getstudentpage.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<PageResult<Demo03StudentErpRespVO>> getDemo03StudentPage(@Valid Demo03StudentErpPageReqVO pageReqVO) {
        PageResult<Demo03StudentDO> pageResult = demo03StudentErpService.getDemo03StudentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, Demo03StudentErpRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportstudent Excel.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDemo03StudentExcel(@Valid Demo03StudentErpPageReqVO pageReqVO,
                                         HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<Demo03StudentDO> list = demo03StudentErpService.getDemo03StudentPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Students.xls", "Data", Demo03StudentErpRespVO.class,
                BeanUtils.toBean(list, Demo03StudentErpRespVO.class));
    }

    // ==================== 子表（学生课程） ====================

    @GetMapping("/demo03-course/page")
    @Operation(summary = "Get student course page.")
    @Parameter(name = "studentId", description = "Student ID")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<PageResult<Demo03CourseDO>> getDemo03CoursePage(PageParam pageReqVO,
                                                                        @RequestParam("studentId") Long studentId) {
        return success(demo03StudentErpService.getDemo03CoursePage(pageReqVO, studentId));
    }

    @PostMapping("/demo03-course/create")
    @Operation(summary = "Create student course.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:create')")
    public CommonResult<Long> createDemo03Course(@Valid @RequestBody Demo03CourseDO demo03Course) {
        return success(demo03StudentErpService.createDemo03Course(demo03Course));
    }

    @PutMapping("/demo03-course/update")
    @Operation(summary = "Update student course.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:update')")
    public CommonResult<Boolean> updateDemo03Course(@Valid @RequestBody Demo03CourseDO demo03Course) {
        demo03StudentErpService.updateDemo03Course(demo03Course);
        return success(true);
    }

    @DeleteMapping("/demo03-course/delete")
    @Parameter(name = "id", description = "Code.", required = true)
    @Operation(summary = "Delete student course.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03Course(@RequestParam("id") Long id) {
        demo03StudentErpService.deleteDemo03Course(id);
        return success(true);
    }

    @DeleteMapping("/demo03-course/delete-list")
    @Parameter(name = "ids", description = "Code.", required = true)
    @Operation(summary = "Batch delete student course.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03CourseList(@RequestParam("ids") List<Long> ids) {
        demo03StudentErpService.deleteDemo03CourseList(ids);
        return success(true);
    }

    @GetMapping("/demo03-course/get")
    @Operation(summary = "Get student course.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<Demo03CourseDO> getDemo03Course(@RequestParam("id") Long id) {
        return success(demo03StudentErpService.getDemo03Course(id));
    }

    // ==================== 子表（学生班级） ====================

    @GetMapping("/demo03-grade/page")
    @Operation(summary = "Getstudent classpage.")
    @Parameter(name = "studentId", description = "Student ID")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<PageResult<Demo03GradeDO>> getDemo03GradePage(PageParam pageReqVO,
                                                                      @RequestParam("studentId") Long studentId) {
        return success(demo03StudentErpService.getDemo03GradePage(pageReqVO, studentId));
    }

    @PostMapping("/demo03-grade/create")
    @Operation(summary = "Createstudent class.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:create')")
    public CommonResult<Long> createDemo03Grade(@Valid @RequestBody Demo03GradeDO demo03Grade) {
        return success(demo03StudentErpService.createDemo03Grade(demo03Grade));
    }

    @PutMapping("/demo03-grade/update")
    @Operation(summary = "Updatestudent class.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:update')")
    public CommonResult<Boolean> updateDemo03Grade(@Valid @RequestBody Demo03GradeDO demo03Grade) {
        demo03StudentErpService.updateDemo03Grade(demo03Grade);
        return success(true);
    }

    @DeleteMapping("/demo03-grade/delete")
    @Parameter(name = "id", description = "Code.", required = true)
    @Operation(summary = "Deletestudent class.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03Grade(@RequestParam("id") Long id) {
        demo03StudentErpService.deleteDemo03Grade(id);
        return success(true);
    }

    @DeleteMapping("/demo03-grade/delete-list")
    @Parameter(name = "ids", description = "Code.", required = true)
    @Operation(summary = "Bulk deletestudent class.")
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:delete')")
    public CommonResult<Boolean> deleteDemo03GradeList(@RequestParam("ids") List<Long> ids) {
        demo03StudentErpService.deleteDemo03GradeList(ids);
        return success(true);
    }

    @GetMapping("/demo03-grade/get")
    @Operation(summary = "Get student class.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('infra:demo03-student:query')")
    public CommonResult<Demo03GradeDO> getDemo03Grade(@RequestParam("id") Long id) {
        return success(demo03StudentErpService.getDemo03Grade(id));
    }

}