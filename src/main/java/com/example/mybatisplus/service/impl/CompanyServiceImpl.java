package  com.example.mybatisplus.service.impl;

import  com.example.mybatisplus.manager.impl.CompanyManagerImpl;
import  com.example.mybatisplus.model.CompanyModel;
import  com.example.mybatisplus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyManagerImpl companyManager;

    @Override
    public CompanyModel getById(Long id) {
        return companyManager.getById(id);
    }
}
