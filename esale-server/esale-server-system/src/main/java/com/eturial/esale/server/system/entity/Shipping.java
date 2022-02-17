package com.eturial.esale.server.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {

   private String shipId;
   private String userId;
   /**
    * 收货人
    * */
   private String consignee;
   /**
    * 联系方式
    * */
   private String conPhone;
   /**
    * 收货地址
    * */
   private String conDistrict;
   /**
    * 详细地址
    * */
   private String conAddr;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
