package com.eturial.esale.server.system.controller;

import com.eturial.esale.server.system.entity.PrePurchase;
import com.eturial.esale.server.system.entity.Product;
import com.eturial.esale.server.system.service.PrePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/prepurchase")
public class PrePurController {

    @Autowired
    private PrePurchaseService prePurchaseService;

    /**
    * 获取购物车/收藏信息
     * */
    @GetMapping("/get/{id}/{op}")
    public List<PrePurchase> getPre(@PathVariable("id") String id, @PathVariable("op") int op){
        PrePurchase prePurchase = new PrePurchase(id,null,op,-1);
        return prePurchaseService.getPrePurchase(prePurchase);
    }

    /**
     * 加入购物车/收藏信息
     * */
    @GetMapping("addPre/{userId}/{proId}/{op}/{quant}")
    public boolean addPre(@PathVariable("userId") String userId,@PathVariable("proId") String proId,
                          @PathVariable("op") int op,@PathVariable("quant") int quant){
        Product product = new Product();
        product.setProId(proId);
        PrePurchase prePurchase = new PrePurchase(userId,product,op,quant);
        return prePurchaseService.addPrePurchase(prePurchase);
    }
    /**
     * 移出购物车/收藏
     * */
    @GetMapping("remove/{userId}/{proId}")
    public boolean removePre(@PathVariable("userId") String userId,@PathVariable("proId") String proId){
        Product product = new Product();
        product.setProId(proId);
        PrePurchase prePurchase = new PrePurchase(userId,product,-1,-1);
        return prePurchaseService.removePrePurchase(prePurchase);
    }
    /**
     * 更新购物车信息
     * */
    @GetMapping("updatePre/{userId}/{proId}/{op}/{quant}")
    public boolean updatePre(@PathVariable("userId") String userId,@PathVariable("proId") String proId,
                             @PathVariable("op") int op,@PathVariable("quant") int quant){
        Product product = new Product();
        product.setProId(proId);
        PrePurchase prePurchase = new PrePurchase(userId,product,op,quant);
        return prePurchaseService.updatePrePurchase(prePurchase);
    }



}
