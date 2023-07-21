package  com.example.mybatisplus.manager;


import  com.example.mybatisplus.model.CompanyModel;

public interface CompanyManager {
    CompanyModel getById(Long id);
}
