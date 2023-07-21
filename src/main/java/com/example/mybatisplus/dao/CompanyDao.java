package  com.example.mybatisplus.dao;

import  com.example.mybatisplus.dto.CompanyDo;
import  com.example.mybatisplus.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyDao {
    @Autowired
    private CompanyMapper companyMapper;

    public CompanyDo getById(Long id) {
        CompanyDo result = companyMapper.getById(id);
        return result;
    }
}
