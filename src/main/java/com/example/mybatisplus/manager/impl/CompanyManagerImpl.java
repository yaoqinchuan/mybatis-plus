package  com.example.mybatisplus.manager.impl;

import com.example.mybatisplus.common.ConvertUtils;
import  com.example.mybatisplus.dao.CompanyDao;
import  com.example.mybatisplus.dto.CompanyDo;
import  com.example.mybatisplus.manager.CompanyManager;
import  com.example.mybatisplus.model.CompanyModel;
import  com.example.mybatisplus.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class CompanyManagerImpl implements CompanyManager {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public CompanyModel getById(Long id) {
        CompanyDo companyDo = companyDao.getById(id);
        CompanyModel companyModel = ConvertUtils.convert(companyDo, CompanyModel.class);
        companyModel.setUserList(companyDo.getUserList().stream().map(user-> ConvertUtils.convert(user, UserModel.class)).collect(Collectors.toList()));
        return companyModel;
    }
}
