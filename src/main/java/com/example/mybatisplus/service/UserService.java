package  com.example.mybatisplus.service;

import  com.example.mybatisplus.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAll();

    Long insertUserUseGeneratedKeys(UserModel userModel);

    Integer deleteByName(String name);

    Integer update(UserModel userModel);

    List<UserModel> queryByCondition(UserModel userModel);

    List<UserModel> queryByPriorityCondition(UserModel userModel);

    Integer deleteByIds(List<Long> ids);

     Integer batchInsert(List<UserModel> userModels);
}
