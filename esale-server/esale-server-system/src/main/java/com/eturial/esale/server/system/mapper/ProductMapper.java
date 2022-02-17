package com.eturial.esale.server.system.mapper;

import com.eturial.esale.server.system.entity.PrePurchase;
import com.eturial.esale.server.system.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    /*
    * 获取所有商品
    * */
    List<Product> getProductList();

    /*
     * 通过商品id来获取商品信息
     * */
    Product getProById(@Param("proId") String proId);


}
