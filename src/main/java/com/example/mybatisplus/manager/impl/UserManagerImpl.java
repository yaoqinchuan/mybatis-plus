package  com.example.mybatisplus.manager.impl;

import com.example.mybatisplus.common.ConvertUtils;
import  com.example.mybatisplus.dao.UserDao;
import  com.example.mybatisplus.dto.UserDo;
import  com.example.mybatisplus.manager.UserManager;
import  com.example.mybatisplus.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserModel> getAll() {
        return userDao.getAll().stream().map(userDo -> ConvertUtils.convert(userDo, UserModel.class)).collect(Collectors.toList());
    }

    @Override
    public Long insertUserUseGeneratedKeys(UserModel userModel) {
        return userDao.insertUserUseGeneratedKeys(ConvertUtils.convert(userModel, UserDo.class));
    }

    @Override
    public Integer deleteByName(String name) {
        return userDao.deleteByName(name);
    }

    @Override
    public Integer update(UserModel userModel) {
        return userDao.update(ConvertUtils.convert(userModel, UserDo.class));
    }

    @Override
    public List<UserModel> queryByCondition(UserModel userModel) {
        return userDao.queryByCondition(ConvertUtils.convert(userModel, UserDo.class)).stream().map(userDo -> ConvertUtils.convert(userDo, UserModel.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserModel> queryByPriorityCondition(UserModel userModel) {
        return userDao.queryByPriorityCondition(ConvertUtils.convert(userModel, UserDo.class)).stream().map(userDo -> ConvertUtils.convert(userDo, UserModel.class)).collect(Collectors.toList());
    }

    @Override
    public Integer deleteByIds(List<Long> ids) {
        return userDao.deleteByIds(ids);
    }

    @Override
    public Integer batchInsert(List<UserModel> userModels) {
        return userDao.batchInsert(userModels.stream().map(userModel->ConvertUtils.convert(userModel, UserDo.class)).collect(Collectors.toList()));
    }
}
