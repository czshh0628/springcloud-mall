package czs.mall.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import czs.mall.api.domain.dto.ItemDTO;
import czs.mall.api.domain.dto.OrderDetailDTO;
import czs.mall.api.domain.po.Item;
import czs.mall.common.exception.BizIllegalException;
import czs.mall.common.utils.BeanUtils;
import czs.mall.item.mapper.ItemMapper;
import czs.mall.item.service.IItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author czs
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Override
    public void deductStock(List<OrderDetailDTO> items) {
        String sqlStatement = "czs.mall.item.mapper.ItemMapper.updateStock";
        boolean r = false;
        try {
            r = executeBatch(items, (sqlSession, entity) -> sqlSession.update(sqlStatement, entity));
        } catch (Exception e) {
            log.error("更新库存异常", e);
            return;
        }
        if (!r) {
            throw new BizIllegalException("库存不足！");
        }
    }

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        return BeanUtils.copyList(listByIds(ids), ItemDTO.class);
    }
}
