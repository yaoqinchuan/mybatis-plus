package  com.example.mybatisplus.dao;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.example.mybatisplus.dto.UserDo;
import  com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<UserDo> getAll() {
        List<UserDo> result = userMapper.getAll();
        return result;
    }

    public Long insertUserUseGeneratedKeys(UserDo userDo) {
        userDo.setGmtCreate(new Date());
        userDo.setGmtModified(new Date());
        userMapper.insert(userDo);
        return userDo.getId();
    }

    public Integer deleteByName(String name) {
        Map<String, Object> map = new HashMap<>(){{
            put("name", name);
        }};
        return userMapper.deleteByMap(map);
    }


    public Integer update(UserDo userDo) {
        userDo.setGmtModified(new Date());
        return userMapper.update(userDo);
    }

    public Page<UserDo> getPaged(Integer index, Integer pageSize) {
        Page<UserDo> page = new Page<>(index, pageSize);
        return userMapper.selectPage(page, null);
    }

    public List<UserDo> queryByCondition(UserDo userDo) {
        return userMapper.selectByMap(BeanUtil.beanToMap(userDo));
    }

    public List<UserDo> queryByPriorityCondition(UserDo userDo) {
        return userMapper.queryByPriorityCondition(userDo);
    }

    public Integer deleteByIds(List<Long> ids) {
        return userMapper.deleteBatchIds(ids);
    }
}
