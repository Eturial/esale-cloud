package com.eturial.esale.server.system.service.impl;


import com.eturial.esale.server.system.entity.Shipping;
import com.eturial.esale.server.system.mapper.ShippingMapper;
import com.eturial.esale.server.system.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShippingServiceImpl")
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public List<Shipping> getMyShipping(String userId) {
        return shippingMapper.selectShipping(userId);
    }

    @Override
    public boolean addMyShipping(Shipping shipping) {
        return shippingMapper.addShipping(shipping);
    }

    @Override
    public boolean deleteMyShipping(String shipId) {
        return shippingMapper.deleteShipping(shipId);
    }

    @Override
    public boolean updateMyShipping(Shipping shipping) {
        return shippingMapper.updateShipping(shipping);
    }
}
