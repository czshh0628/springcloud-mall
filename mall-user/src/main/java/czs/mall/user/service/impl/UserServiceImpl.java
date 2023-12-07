package czs.mall.user.service.impl;


import cn.hutool.core.util.ObjUtil;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import czs.mall.api.domain.dto.LoginFormDTO;
import czs.mall.api.domain.po.User;
import czs.mall.api.domain.vo.UserLoginVO;
import czs.mall.api.enums.UserStatus;
import czs.mall.common.exception.BadRequestException;
import czs.mall.common.exception.BizIllegalException;
import czs.mall.common.exception.ForbiddenException;
import czs.mall.common.utils.UserContext;
import czs.mall.user.mapper.UserMapper;
import czs.mall.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 虎哥
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserLoginVO login(LoginFormDTO loginDTO) {
        // 1.数据校验
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        // 2.根据用户名或手机号查询
        User user = lambdaQuery().eq(User::getUsername, username).one();
        if (ObjUtil.isNull(user)) {
            throw new BadRequestException("用户不存在");
        }
        // 3.校验是否禁用
        if (user.getStatus() == UserStatus.FROZEN) {
            throw new ForbiddenException("用户被冻结");
        }
        // 4.校验密码
        if (!loginDTO.getPassword().equals(user.getPassword())) {
            throw new BadRequestException("密码错误");
        }
        // 5.生成TOKEN
        String token = JWTUtil.createToken(new HashMap<String, Object>(), String.valueOf(user.getId()).getBytes());
        // 6.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setBalance(user.getBalance());
        vo.setToken(token);
        return vo;
    }

    @Override
    public void deductMoney(String pw, Integer totalFee) {
        log.info("开始扣款");
        // 1.校验密码
        User user = getById(UserContext.getUser());
        if (user == null || !user.getPassword().equals(pw)) {
            // 密码错误
            throw new BizIllegalException("用户密码错误");
        }

        // 2.尝试扣款
        try {
            baseMapper.updateMoney(UserContext.getUser(), totalFee);
        } catch (Exception e) {
            throw new RuntimeException("扣款失败，可能是余额不足！", e);
        }
        log.info("扣款成功");
    }
}
