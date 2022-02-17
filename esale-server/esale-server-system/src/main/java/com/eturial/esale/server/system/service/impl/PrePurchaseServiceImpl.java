package com.eturial.esale.server.system.service.impl;

import com.eturial.esale.server.system.entity.PrePurchase;
import com.eturial.esale.server.system.mapper.PrePurchaseMapper;
import com.eturial.esale.server.system.service.PrePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PrePurchaseServiceImpl")
public class PrePurchaseServiceImpl implements PrePurchaseService {

    @Autowired
    PrePurchaseMapper prePurchaseMapper;

    @Override
    public List<PrePurchase> getPrePurchase(PrePurchase prePurchase) {
        return prePurchaseMapper.getPrePurchase(prePurchase);
    }

    @Override
    public boolean addPrePurchase(PrePurchase prePurchase) {
        return prePurchaseMapper.addPrePurchase(prePurchase);
    }

    @Override
    public boolean removePrePurchase(PrePurchase prePurchase) {
        return prePurchaseMapper.deletePrePurchase(prePurchase);
    }

    @Override
    public boolean updatePrePurchase(PrePurchase prePurchase) {
        return prePurchaseMapper.updatePrePurchase(prePurchase);
    }
}
