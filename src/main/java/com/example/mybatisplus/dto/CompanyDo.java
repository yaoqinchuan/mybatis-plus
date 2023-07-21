package  com.example.mybatisplus.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "company")
public class CompanyDo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "worker_count")
    private Long workerCount;
    @TableField(exist = false)
    private List<UserDo> userList;
    @TableField(value = "gmt_create")
    private Date gmtCreate;
    @TableField(value = "gmt_modified")
    private Date gmtModified;
}
