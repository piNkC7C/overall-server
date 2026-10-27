package cn.iocoder.yudao.module.report.framework.jmreport.core.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import cn.iocoder.yudao.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import cn.iocoder.yudao.framework.common.biz.system.permission.PermissionCommonApi;
import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.util.servlet.ServletUtils;
import cn.iocoder.yudao.framework.security.config.SecurityProperties;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.framework.tenant.core.context.TenantContextHolder;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.system.enums.permission.RoleCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.jeecg.modules.jmreport.api.JmReportTokenServiceI;
import org.springframework.http.HttpHeaders;

import java.util.Objects;

/**
 * {@link JmReportTokenServiceI} 实现类，提供积木报表的 Token 校验、用户信息的查询等功能
 *
 * @author 随心
 */
@RequiredArgsConstructor
public class JmReportTokenServiceImpl implements JmReportTokenServiceI {

    /**
     * 积木 token head 头
     */
    private static final String JM_TOKEN_HEADER = "X-Access-Token";
    /**
     * auth 相关格式
     */
    private static final String AUTHORIZATION_FORMAT = SecurityFrameworkUtils.AUTHORIZATION_BEARER + " %s";

    private final OAuth2TokenCommonApi oauth2TokenApi;
    private final PermissionCommonApi permissionApi;

    private final SecurityProperties securityProperties;

    /**
     * 自定义 API 数据集appian自定义 Header，解决 Token 传递。
     * 参考 <a href="http://report.jeecg.com/2222224">api数据集token机制详解</a> 文档
     *
     * @return 新 head
     */
    @Override
    public HttpHeaders customApiHeader() {
        // 读取积木标标系统的 token
        HttpServletRequest request = ServletUtils.getRequest();
        String token = request.getHeader(JM_TOKEN_HEADER);

        // Set to yudao System token
        HttpHeaders headers = new HttpHeaders();
        headers.add(securityProperties.getTokenHeader(), String.format(AUTHORIZATION_FORMAT, token));
        return headers;
    }

    /**
     * 校验 Token 是否有效，即验证通过
     *
     * @param token JmReport 前端传递的 token
     * @return 是否认证通过
     */
    @Override
    public Boolean verifyToken(String token) {
        Long userId = SecurityFrameworkUtils.getLoginUserId();
        if (!Objects.isNull(userId)) {
            return true;
        }
        return buildLoginUserByToken(token) != null;
    }

    /**
     * 获得用户编号
     * <p>
     * 虽然方法名获得的是 username，实际对应到项目中是用户编号
     *
     * @param token JmReport 前端传递的 token
     * @return 用户编号
     */
    @Override
    public String getUsername(String token) {
        Long userId = SecurityFrameworkUtils.getLoginUserId();
        if (ObjectUtil.isNotNull(userId)) {
            return String.valueOf(userId);
        }
        LoginUser user = buildLoginUserByToken(token);
        return user == null ? null : String.valueOf(user.getId());
    }

    /**
     * 基于 token 构建登录用户
     *
     * @param token token
     * @return 返回 token 对应的用户信息
     */
    private LoginUser buildLoginUserByToken(String token) {
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        // TODO 如下的实现不算特别优雅，主要咱是不想搞的太复杂，所以参考对应的 Filter 先实现了

        // ① 参考 TokenAuthenticationFilter 的认证逻辑（Security 的上下文清理，交给 Spring Security 完成）
        // 目的：实现基于 JmReport 前端传递的 token，实现认证
        TenantContextHolder.setIgnore(true); // 忽略租户，保证可查询到 token 信息
        LoginUser user = null;
        try {
            OAuth2AccessTokenCheckRespDTO accessToken = oauth2TokenApi.checkAccessToken(token).getCheckedData();
            if (accessToken == null) {
                return null;
            }
            user = new LoginUser().setId(accessToken.getUserId()).setUserType(accessToken.getUserType())
                    .setTenantId(accessToken.getTenantId()).setScopes(accessToken.getScopes());
        } catch (ServiceException ignored) {
            // do nothing：如果报错，说明认证失败，则返回 false 即可
        }
        if (user == null) {
            return null;
        }
        SecurityFrameworkUtils.setLoginUser(user, WebFrameworkUtils.getRequest());

        // ② 参考 TenantContextWebFilter 实现（Tenant 的上下文清理，交给 TenantContextWebFilter 完成）
        // 目的：基于 LoginUser 获得到的租户编号，设置到 Tenant 上下文，避免查询数据库时的报错
        TenantContextHolder.setIgnore(false);
        TenantContextHolder.setTenantId(user.getTenantId());
        return user;
    }

    @Override
    public String[] getRoles(String token) {
        // 设置租户上下文。原因是：/jmreport/** 纯前端地址，不会走 buildLoginUserByToken 逻辑
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser == null) {
            return null;
        }
        TenantContextHolder.setTenantId(loginUser.getTenantId());

        // See document https://help.jeecg.com/jimureport/prodSafe.html document
        // 适配：如果是本系统的管理员，则转换成 jimu 报表的管理员
        Long userId = SecurityFrameworkUtils.getLoginUserId();
        return permissionApi.hasAnyRoles(userId, RoleCodeEnum.SUPER_ADMIN.getCode()).getCheckedData()
                ? new String[]{"admin"} : null;
    }

    @Override
    public String getTenantId() {
        // 补充说明：不能直接通过 TenantContext 获取，因为 jimu 报表前端请求时，没有带上 tenant-id Header
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser == null) {
            return null;
        }
        return StrUtil.toStringOrNull(loginUser.getTenantId());
    }

    @Override
    public String[] getPermissions(String token) {
        // 设置租户上下文
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser == null) {
            return null;
        }
        TenantContextHolder.setTenantId(loginUser.getTenantId());

        // See document https://help.jimureport.com/prodSafe/ document
        // 适配：如果是本系统的管理员，则返回积木报表（仪表盘/大屏设计器、报表设计器）的所有权限指令
        // 如果不处理，会碰到 https://t.zsxq.com/yzlkA 反馈的问题
        // 权限清单参考 https://gitee.com/zhijiantianya/ruoyi-vue-pro/pulls/1600
        Long userId = SecurityFrameworkUtils.getLoginUserId();
        if (permissionApi.hasAnyRoles(userId, RoleCodeEnum.SUPER_ADMIN.getCode()).getCheckedData()) {
            return new String[]{
                    // ========== 第一块：大屏（仪表盘 BI）按钮权限 ==========
                    "drag:datasource:testConnection",       // 数据源连接测试
                    "drag:datasource:saveOrUpate",          // Data source create / edit
                    "drag:datasource:delete",               // Data sourcedelete
                    "drag:datasource:deleteBatch",          // Data source batch delete
                    "drag:datasource:queryById",            // Data source details search
                    "drag:dataset:save",                    // 数据集保存
                    "drag:dataset:delete",                  // 数据集删除
                    "drag:analysis:sql",                    // SQL解析
                    "drag:design:getTotalData",             // 仪表盘对Online表单展示数据
                    "drag:iconlib:config",                  // 图标库配置
                    "onl:drag:clear:recovery",              // 清空回收站
                    "onl:drag:page:delete",                 // 仪表盘页面删除
                    "onl:drag:category:delete",             // 仪表盘分类删除
                    "onl:drag:comp:add",                    // Group pcs create
                    "onl:drag:comp:edit",                   // Group pcs edit
                    "onl:drag:comp:delete",                 // Group pcsdelete
                    "onl:drag:comp:deleteBatch",            // Group pcs batch delete
                    "onl:drag:getRawTableData",             // 获取原始表数据
                    // ========== 第二块：积木报表按钮权限 ==========
                    "jmreport:exportJob:plugin",            // 导出任务-插件
                    "jmreport:exportJob:list",              // Exporttask- list
                    "jmreport:exportJob:save",              // Exporttask- save
                    "jmreport:exportJob:detail",            // Exporttask- details
                    "jmreport:exportJob:delete",            // Exporttask-delete
                    "jmreport:exportJob:status",            // 导出任务-状态变更
                    "jmreport:exportJob:run",               // Exporttask- execute
                    "jmreport:exportJob:export",            // Exporttask-export
                    "jmreport:map:add",                     // 地图-新增
                    "jmreport:map:delete",                  // 地图-删除
                    "jmreport:reportGroup:list",            // Report group - list
                    "jmreport:reportGroup:detail",          // Report group - details
                    "jmreport:reportGroup:save",            // Report group - save
                    "jmreport:reportGroup:delete",          // Report group -delete
                    "jmreport:category:add",                // Reportcategory- create
                    "jmreport:category:edit",               // Reportcategory- edit
                    "jmreport:category:delete",             // Reportcategory-delete
                    "jmreport:category:reduction",          // 报表分类-还原
                    "jmreport:category:completelyDelete",   // Reportcategory- permanently delete
                    "jmreport:category:batchMove",          // Reportcategory- batch move
                    "jmreport:category:folderSort",         // Reportcategory- folder sort
                    "jmreport:datasource:testConnection",   // 数据源-连接测试
                    "jmreport:datasource:saveOrUpate",      // Data source- create / edit
                    "jmreport:datasource:delete",           // Data source-delete
                    "jmreport:datasource:query",            // Data source-search( list / details )
                    "jmreport:design:loadTableData",        // 设计器-加载表数据
                    "jmreport:design:parseField",           // 设计器-解析字段(SQL/API/JavaBean/填报处理器)
                    "jmreport:design:loadTable",            // 设计器-库表/字段元数据查询
                    "jmreport:design:saveDb",               // 设计器-数据集保存
                    "jmreport:design:filesDataset",         // 设计器-文件数据集
                    "jmreport:design:editEnhance",          // 设计器-增强代码(JS/CSS/Python)
                    "jmreport:ai:tableMeta",                // AI-表元数据管理
                    "jimu:chat2bi:permEdit"                 // Chat2BI- permission edit
            };
        }
        return null;
    }

}
