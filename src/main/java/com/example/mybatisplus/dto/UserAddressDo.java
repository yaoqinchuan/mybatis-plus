package  com.example.mybatisplus.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user_address")
public class UserAddressDo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "zip_code")
    private String zipCode;
    @TableField(value = "address")
    private String address;
    @TableField(value = "gmt_create")
    private Date gmtCreate;
    @TableField(value = "gmt_modified")
    private Date gmtModified;
}
