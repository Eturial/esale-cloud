package com.eturial.esale.server.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eturial.esale.common.entity.system.SystemUser;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    @TableId(value = "product_id", type = IdType.UUID)
    private String proId;

    @TableField("product_name")
    private String proName;

    @TableField("product_detail")
    private String detail;

    @TableField("product_price")
    private Double price;

    /**
     * 库存
     */
    @TableField("product_stock")
    private int stock;

    /**
     * 状态 0下架  1上架
     */
    @TableField("STATUS")
    private String status;


    private SaleUser user;
//    /**
//     * 用户 ID
//     */
//    @TableId(value = "user_id", type = IdType.UUID)
//    private String userId;
//
//    /**
//     * 用户名
//     */
//    private String username;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 图片
     */
    private List<ProductPicture> picture;

}
