package czs.mall.api.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserClient {

    @PutMapping("/users/money/deduct")
     void deductMoney(@RequestParam("pw") String pw,@RequestParam("amount") Integer amount);

}
