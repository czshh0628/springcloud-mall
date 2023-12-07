package czs.mall.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cart-service")
public interface CartClient {

    @DeleteMapping("/carts")
    void deleteCarByIds(@RequestParam("ids") List<Long> ids);

    @DeleteMapping
    void deleteCartItemByIds(@RequestParam("ids") List<Long> ids);
}
