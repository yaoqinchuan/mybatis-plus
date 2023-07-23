package com.example.mybatisplus.controller;

import com.example.mybatisplus.common.CommonResult;
import com.example.mybatisplus.common.LocalPage;
import com.example.mybatisplus.model.UserModel;
import com.example.mybatisplus.service.impl.UserServiceImpl;
import com.example.mybatisplus.validator.UserControllerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public CommonResult<List<UserModel>> getAll() {
        return CommonResult.success(userServiceImpl.getAll());
    }

    @RequestMapping(path = "/all/page", method = RequestMethod.GET)
    public CommonResult<LocalPage<UserModel>> getPaged(
            @RequestParam(name = "index", defaultValue = "0") Integer index,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return CommonResult.success(userServiceImpl.getPaged(index, pageSize));
    }

    @RequestMapping(path = "/all/count", method = RequestMethod.GET)
    public CommonResult<Long> getAllCount() {
        return CommonResult.success(userServiceImpl.queryCount());
    }


    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public CommonResult<Integer> deleteByName(@RequestParam(name = "name", required = true) String name) {
        return CommonResult.success(userServiceImpl.deleteByName(name));
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public CommonResult<Long> insert(@RequestBody UserModel userModel) {
        return CommonResult.success(userServiceImpl.insertUserUseGeneratedKeys(userModel));
    }

    @RequestMapping(path = "/batch", method = RequestMethod.POST)
    public CommonResult<Boolean> batchInsert(@RequestBody List<UserModel> userModels) {
        return CommonResult.success(userServiceImpl.batchInsert(userModels));
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public CommonResult<Integer> update(@RequestBody UserModel userModel) {
        UserControllerValidator.updateValidator(userModel);
        return CommonResult.success(userServiceImpl.update(userModel));
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public CommonResult<List<UserModel>> getByCondition(@RequestBody UserModel userModel) {
        return CommonResult.success(userServiceImpl.queryByCondition(userModel));
    }

    @RequestMapping(path = "/merge/condition", method = RequestMethod.GET)
    public CommonResult<List<UserModel>> getByPriorityCondition(@RequestBody UserModel userModel) {
        return CommonResult.success(userServiceImpl.queryByPriorityCondition(userModel));
    }

    @RequestMapping(path = "/ids", method = RequestMethod.DELETE)
    public CommonResult<Integer> deleteByIds(@RequestParam(name = "ids") List<Long> ids) {
        return CommonResult.success(userServiceImpl.deleteByIds(ids));
    }

}
