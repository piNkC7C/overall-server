package cn.iocoder.yudao.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 芋道源码
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "Application started successfully!\n\t" +
                            "API docs:\t{} \n\t" +
                            "Developer docs:\t{} \n\t" +
                            "Video tutorials:\t{} \n" +
                            "----------------------------------------------------------",
                    "https://cloud.iocoder.cn/api-doc/",
                    "https://cloud.iocoder.cn",
                    "https://t.zsxq.com/02Yf6M7Qn");

            // 工作流
            System.out.println("[Workflow module yudao-module-bpm][See https://cloud.iocoder.cn/bpm/]");
            // Payment Platform
            System.out.println("[Payment module yudao-module-pay][See https://doc.iocoder.cn/pay/build/]");
            // Data report
            System.out.println("[Report module yudao-module-report][See https://cloud.iocoder.cn/report/]");
            // WeChatOfficial Account
            System.out.println("[Official account module yudao-module-mp][See https://cloud.iocoder.cn/mp/build/]");
            // Shop System
            System.out.println("[Mall module yudao-module-mall][See https://cloud.iocoder.cn/mall/build/]");
            // ERP
            System.out.println("[ERP module yudao-module-erp][See https://cloud.iocoder.cn/erp/build/]");
            // WMS warehouse admin System
            System.out.println("[WMS module yudao-module-wms][See https://cloud.iocoder.cn/wms/build/]");
            // CRM
            System.out.println("[CRM module yudao-module-crm][See https://cloud.iocoder.cn/crm/build/]");
            // MES System
            System.out.println("[MES module yudao-module-mes][See https://cloud.iocoder.cn/mes/build/]");
            // HRM labor resource admin System
            System.out.println("[HRM module yudao-module-hrm][See https://cloud.iocoder.cn/hrm/build/]");
            // FMS 财务管理系统
            System.out.println("[FMS module yudao-module-fms][See https://cloud.iocoder.cn/fms/build/]");
            // PMS item admin System
            System.out.println("[PMS module yudao-module-pms][See https://cloud.iocoder.cn/pms/build/]");
            // OA 办公自动化
            System.out.println("[OA module yudao-module-oa][See https://cloud.iocoder.cn/oa/build/]");
            // AI 大模型
            System.out.println("[AI module yudao-module-ai][See https://cloud.iocoder.cn/ai/build/]");
            // IoT
            System.out.println("[IoT module yudao-module-iot][See https://doc.iocoder.cn/iot/build/]");
            // IM 即时通讯
            System.out.println("[IM module yudao-module-im][See https://cloud.iocoder.cn/im/build/]");
        });
    }

}
