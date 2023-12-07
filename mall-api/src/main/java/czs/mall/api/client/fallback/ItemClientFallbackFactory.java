package czs.mall.api.client.fallback;

import java.util.Collections;
import java.util.List;

import czs.mall.api.client.ItemClient;
import czs.mall.api.domain.dto.ItemDTO;
import czs.mall.api.domain.dto.OrderDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * 熔断
 *
 * @author czs
 */
@Slf4j
public class ItemClientFallbackFactory implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(List<Long> ids) {
                //查询失败返回空集合
                return Collections.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) throws Exception {
                //查询失败返回空集合
                throw new Exception("Failed to duplicate stock");
            }
        };
    }
}