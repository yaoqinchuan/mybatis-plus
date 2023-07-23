package  com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import  com.example.mybatisplus.dto.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDo> {

    List<UserDo> getAll();

    Integer update(UserDo userDo);


    List<UserDo> queryByPriorityCondition(UserDo userDo);

    Integer batchInsert(@Param("userDos") List<UserDo> userDos);
}
