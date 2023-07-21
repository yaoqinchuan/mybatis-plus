package  com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import  com.example.mybatisplus.dto.CompanyDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapper<CompanyDo> {
    CompanyDo getById(Long id);
}
