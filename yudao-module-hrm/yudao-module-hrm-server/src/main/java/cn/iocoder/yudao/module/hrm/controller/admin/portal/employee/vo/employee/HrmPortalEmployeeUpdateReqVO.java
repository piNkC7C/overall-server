package cn.iocoder.yudao.module.hrm.controller.admin.portal.employee.vo.employee;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.hrm.enums.employee.experience.HrmEmployeeEducationEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeIdTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee profile update request VO.")
@Data
public class HrmPortalEmployeeUpdateReqVO {

    @Schema(description = "Employee Name", example = "John.")
    @Size(max = 255, message = "Employee Name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Phone number.", example = "15601691300")
    @Mobile
    private String mobile;

    @Schema(description = "Country / Region", example = "China")
    @Size(max = 64, message = "Country / Region cannot exceed 64 characters.")
    private String country;

    @Schema(description = "Ethnicity", example = "Han")
    @Size(max = 64, message = "Ethnicity cannot exceed 64 characters.")
    private String nation;

    @Schema(description = "ID Type", example = "1")
    @InEnum(value = HrmEmployeeIdTypeEnum.class, message = "ID Type must be {value}.")
    private Integer idType;

    @Schema(description = "ID Number", example = "310101199001011234")
    @Size(max = 255, message = "ID Number cannot exceed 255 characters.")
    private String idNumber;

    @Schema(description = "Gender", example = "1")
    private Integer sex;

    @Schema(description = "Email", example = "hrm@example.com")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
    private String email;

    @Schema(description = "Hometown", example = "Hangzhou, Zhejiang")
    @Size(max = 128, message = "Hometown cannot exceed 128 characters.")
    private String nativePlace;

    @Schema(description = "Date of birth")
    @PastOrPresent(message = "Date of birth cannot be later than today.")
    private LocalDateTime birthday;

    @Schema(description = "Household Address", example = "Xihu District, Hangzhou")
    @Size(max = 255, message = "Household Address cannot exceed 255 characters.")
    private String address;

    @Schema(description = "Highest Education", example = "8")
    @InEnum(value = HrmEmployeeEducationEnum.class, message = "Highest Education must be {value}.")
    private Integer highestEducation;

    @AssertTrue(message = "ID number format is invalid.")
    @JsonIgnore
    public boolean isIdNumberValid() {
        return ObjUtil.notEqual(HrmEmployeeIdTypeEnum.ID_CARD.getType(), idType)
                || StrUtil.isBlank(idNumber) || IdcardUtil.isValidCard(idNumber);
    }

}
