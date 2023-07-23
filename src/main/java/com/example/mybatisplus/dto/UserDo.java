package  com.example.mybatisplus.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class UserDo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "email")
    private String email;
    @TableField(value = "phone")
    private String phone;
    @TableField(exist = false)
    private UserAddressDo userAddress;
    @TableField(value = "company_name")
    private String companyName;
    @TableField(value = "address_id")
    private Long addressId;
    @TableField(value = "gmt_create")
    private Date gmtCreate;
    @TableField(value = "gmt_modified")
    private Date gmtModified;
}
