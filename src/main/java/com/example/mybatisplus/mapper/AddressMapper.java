package  com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import  com.example.mybatisplus.dto.UserAddressDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper extends BaseMapper<UserAddressDo> {
    UserAddressDo getById(Long id);
}
