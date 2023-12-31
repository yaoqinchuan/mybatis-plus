package  com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.LocalPage;
import  com.example.mybatisplus.manager.impl.UserManagerImpl;
import  com.example.mybatisplus.model.UserModel;
import  com.example.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserManagerImpl userManagerImpl;

    @Override
    public List<UserModel> getAll() {
        List<UserModel> result = userManagerImpl.getAll();
        return result;
    }

    @Override
    public Long insertUserUseGeneratedKeys(UserModel userModel) {
        return userManagerImpl.insertUserUseGeneratedKeys(userModel);
    }

    @Override
    public Integer deleteByName(String name) {
        return userManagerImpl.deleteByName(name);
    }

    @Override
    public Integer update(UserModel userModel) {
        return userManagerImpl.update(userModel);
    }

    @Override
    public List<UserModel> queryByCondition(UserModel userModel) {
        return userManagerImpl.queryByCondition(userModel);
    }

    @Override
    public List<UserModel> queryByPriorityCondition(UserModel userModel) {
        return userManagerImpl.queryByPriorityCondition(userModel);
    }

    @Override
    public Integer deleteByIds(List<Long> ids) {
        return userManagerImpl.deleteByIds(ids);
    }

    public Boolean batchInsert(List<UserModel> userModels){
        Boolean result = userManagerImpl.batchInsert(userModels);
        return result;
    }

    @Override
    public LocalPage<UserModel> getPaged(Integer index, Integer pageSize) {
        return userManagerImpl.getPaged(index, pageSize);
    }

    @Override
    public Long queryCount() {
        return userManagerImpl.queryCount();
    }
}
