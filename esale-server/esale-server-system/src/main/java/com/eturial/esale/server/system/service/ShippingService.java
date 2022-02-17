package com.eturial.esale.server.system.service;


import com.eturial.esale.server.system.entity.Shipping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShippingService {
    /**
     * 获取收货地址信息列表
     * */
    List<Shipping> getMyShipping(String userId);
    /**
     * 新增收货地址
     * */
    boolean addMyShipping(Shipping shipping);
    /**
     * 删除收货地址
     * */
    boolean deleteMyShipping(String shipId);
    /**
    * 更新收货地址
    * */
    boolean updateMyShipping(Shipping shipping);

}
