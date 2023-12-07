package czs.mall.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import czs.mall.api.domain.dto.LoginFormDTO;
import czs.mall.api.domain.po.User;
import czs.mall.api.domain.vo.UserLoginVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}
