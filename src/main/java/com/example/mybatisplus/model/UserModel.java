package  com.example.mybatisplus.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserModel {
    private String name;
    private Long id;
    private String email;
    private String phone;
    private UserModel userAddress;
    private List<CompanyModel> scoreModels;
    private Date gmtCreate;
    private Date gmtModified;
}
