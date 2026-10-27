package cn.iocoder.yudao.module.crm.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - CRM product category list request.")
@Data
public class CrmProductCategoryListReqVO {

    @ExcelProperty("Name")
    private String name;

    @ExcelProperty("Parent ID")
    private Long parentId;

    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
