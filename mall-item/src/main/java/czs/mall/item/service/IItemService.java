package czs.mall.item.service;


import com.baomidou.mybatisplus.extension.service.IService;
import czs.mall.api.domain.dto.ItemDTO;
import czs.mall.api.domain.dto.OrderDetailDTO;
import czs.mall.api.domain.po.Item;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author czs
 * @since 2023-05-05
 */
public interface IItemService extends IService<Item> {

    void deductStock(List<OrderDetailDTO> items);

    List<ItemDTO> queryItemByIds(Collection<Long> ids);
}
