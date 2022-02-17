package com.eturial.esale.server.system.mapper;


import com.eturial.esale.server.system.entity.PrePurchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrePurchaseMapper {

    /**
     * 获取购物车/收藏 信息
     * */
    List<PrePurchase> getPrePurchase(@Param("prePurchase") PrePurchase prePurchase);
    /**
     * 加入购物车/收藏
     * */
    boolean addPrePurchase(@Param("prePurchase") PrePurchase prePurchase);
    /**
     * 移出购物车/收藏
     * */
    boolean deletePrePurchase(@Param("prePurchase") PrePurchase prePurchase);
    /**
     * 更新购物车信息
     * */
    boolean updatePrePurchase(@Param("prePurchase") PrePurchase prePurchase);
}
