package czs.mall.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import czs.mall.api.domain.po.Address;
import czs.mall.user.mapper.AddressMapper;
import czs.mall.user.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czs
 * @since 2023-05-05
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
