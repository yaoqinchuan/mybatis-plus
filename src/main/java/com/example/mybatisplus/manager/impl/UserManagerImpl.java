package com.example.mybatisplus.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.common.LocalPage;
import com.example.mybatisplus.utils.ConvertUtils;
import com.example.mybatisplus.dao.UserDao;
import com.example.mybatisplus.dto.UserDo;
import com.example.mybatisplus.manager.UserManager;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.UserModel;
import com.example.mybatisplus.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserManagerImpl extends ServiceImpl<UserMapper, UserDo> implements UserManager, IService<UserDo> {
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
    public LocalPage<UserModel> getPaged(Integer index, Integer pageSize) {
        Page<UserDo> resultDos = userDao.getPaged(index, pageSize);
        return PageUtils.convertToLocalPage(resultDos, UserModel.class);
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
    public Boolean batchInsert(List<UserModel> userModels) {
        return saveBatch(userModels.stream().map(userModel ->
        {
            userModel.setGmtCreate(new Date());
            userModel.setGmtModified(new Date());
            UserDo result = ConvertUtils.convert(userModel, UserDo.class);
            return result;
        }).collect(Collectors.toList()));
    }

    @Override
    public Long queryCount() {
        return count();
    }
}
