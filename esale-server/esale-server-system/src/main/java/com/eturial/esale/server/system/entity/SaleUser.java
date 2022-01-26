package com.eturial.esale.server.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("users")
public class SaleUser implements Serializable {
    private static final long serialVersionUID = -4352868070794165001L;

    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    @TableField("username")
    private String username;
}
