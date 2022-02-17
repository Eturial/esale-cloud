package com.eturial.esale.server.system.service;
import com.eturial.esale.server.system.entity.PrePurchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrePurchaseService {

    /**
    * 获取购物车/收藏信息
    * */
    List<PrePurchase> getPrePurchase(PrePurchase prePurchase);
    /**
     * 加入购物车/收藏
     * */
    boolean addPrePurchase(PrePurchase prePurchase);
    /**
     * 移出购物车/收藏
     * */
    boolean removePrePurchase(PrePurchase prePurchase);
    /**
     * 更新购物车信息
     * */
    boolean updatePrePurchase(PrePurchase prePurchase);
}
