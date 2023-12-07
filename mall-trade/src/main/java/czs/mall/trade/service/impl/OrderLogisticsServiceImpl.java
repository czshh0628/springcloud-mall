package czs.mall.trade.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import czs.mall.api.domain.po.OrderLogistics;
import czs.mall.trade.mapper.OrderLogisticsMapper;
import czs.mall.trade.service.IOrderLogisticsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
@Service
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements IOrderLogisticsService {

}
