package com.eturial.esale.server.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("picture")
public class ProductPicture implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    @TableId(value = "pic_id", type = IdType.UUID)
    private String picId;

    @TableField("product_id")
    private String proId;

    @TableField("url")
    private String url;
}
