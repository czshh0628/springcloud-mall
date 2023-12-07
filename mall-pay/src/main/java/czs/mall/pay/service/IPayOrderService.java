package czs.mall.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import czs.mall.api.domain.dto.PayApplyDTO;
import czs.mall.api.domain.dto.PayOrderFormDTO;
import czs.mall.api.domain.po.PayOrder;


/**
 * <p>
 * 支付订单 服务类
 * </p>
 *
 * @author czs
 * @since 2023-05-16
 */
public interface IPayOrderService extends IService<PayOrder> {

    String applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
