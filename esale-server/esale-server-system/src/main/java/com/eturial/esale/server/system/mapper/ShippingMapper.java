package com.eturial.esale.server.system.mapper;

import com.eturial.esale.server.system.entity.Shipping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippingMapper {
   /**
    * 查看收货地址
    * */
   List<Shipping> selectShipping(@Param("userId") String userId);
    /**
     * 添加收货地址
     * */
    boolean addShipping(@Param("shipping") Shipping shipping);

    /**
     * 删除收货地址
     * */
    boolean deleteShipping(@Param("shipId") String shipId);

    /**
     * 修改收货地址信息
     * */
    boolean updateShipping(@Param("shipping") Shipping shipping);
}
