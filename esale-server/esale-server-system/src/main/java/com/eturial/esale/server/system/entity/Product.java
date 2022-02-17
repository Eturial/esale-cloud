package com.eturial.esale.server.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product  {

    private String proId;

    private String proName;

    private String detail;

    private Double price;

    /**
     * 库存
     */

    private int stock;

    /**
     * 状态 0下架  1上架
     */

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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 图片
     */
    private List<ProductPicture> picture;

    /**
     * 商品分类
     * */
    private ProductClass productClass;

}
