package  com.example.mybatisplus.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompanyModel {
    private Long id;
    private String name;
    private Date createTime;
    private Long workerCount;
    private List<UserModel> userList;
    private Date gmtCreate;
    private Date gmtModified;
}
