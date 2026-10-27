package cn.iocoder.yudao.module.crm.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.crm.dal.dataobject.product.CrmProductCategoryDO;
import cn.iocoder.yudao.module.crm.enums.DictTypeConstants;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;
import org.dromara.core.trans.anno.Trans;
import org.dromara.core.trans.constant.TransType;
import org.dromara.core.trans.vo.VO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - CRM product response.")
@Data
@ExcelIgnoreUnannotated
public class CrmProductRespVO implements VO {

    @Schema(description = "Product code.", example = "20529")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Good product")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12306")
    @ExcelProperty("Product Code")
    private String no;

    @Schema(description = "Order characters.", example = "2")
    @ExcelProperty(value = "Unit", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_PRODUCT_UNIT)
    private int unit;

    @Schema(description = "Price, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
    @ExcelProperty("Price, In Cents")
    private BigDecimal price;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Put away.")
    @ExcelProperty(value = "Unit", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_PRODUCT_STATUS)
    private Integer status;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @Trans(type = TransType.SIMPLE, target = CrmProductCategoryDO.class, fields = "name", ref = "categoryName")
    private Long categoryId;
    @Schema(description = "Product category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Clothes")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "ProductDescription.", example = "Looks good.")
    @ExcelProperty("Product Description")
    private String description;

    @Schema(description = "Owner person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31926")
    @Trans(type = TransType.AUTO_TRANS, key = AdminUserApi.PREFIX,
            fields = "nickname", ref = "ownerUserName")
    private Long ownerUserId;
    @Schema(description = "Owner person nickname.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Owner")
    private String ownerUserName;

    @Schema(description = "Creator code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @Trans(type = TransType.AUTO_TRANS, key = AdminUserApi.PREFIX,
            fields = "nickname", ref = "creatorName")
    private String creator;
    @Schema(description = "Creator name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @ExcelProperty("Creator")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

}
