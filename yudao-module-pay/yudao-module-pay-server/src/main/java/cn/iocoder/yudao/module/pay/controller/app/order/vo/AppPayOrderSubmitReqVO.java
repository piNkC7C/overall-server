package cn.iocoder.yudao.module.pay.controller.app.order.vo;

import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderSubmitReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User APP - payment submit request.")
@Data
public class AppPayOrderSubmitReqVO  extends PayOrderSubmitReqVO {
}
