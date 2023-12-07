package czs.mall.cart.service;



import com.baomidou.mybatisplus.extension.service.IService;
import czs.mall.api.domain.dto.CartFormDTO;
import czs.mall.api.domain.po.Cart;
import czs.mall.api.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 订单详情表 服务类
 * </p>
 *
 * @author czs
 * @since 2023-05-05
 */
public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}
