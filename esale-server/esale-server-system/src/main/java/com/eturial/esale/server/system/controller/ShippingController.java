package com.eturial.esale.server.system.controller;

import com.eturial.esale.server.system.entity.Shipping;
import com.eturial.esale.server.system.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/get/{id}")
    public List<Shipping> getMyShippingList(@PathVariable("id") String userid){
        return shippingService.getMyShipping(userid);
    }

    @GetMapping("/add/{id}/{name}/{phone}/{district}/{addr}")
    public boolean addMyShipping(@PathVariable("id") String userid,
                                 @PathVariable("name") String name,
                                 @PathVariable("phone") String phone,
                                 @PathVariable("district") String district,
                                 @PathVariable("addr") String addr){
        Shipping shipping = new Shipping("5",userid,name,phone,district,addr,null,null);
        return shippingService.addMyShipping(shipping);
    }

    @GetMapping("/del/{id}")
    public boolean deleteMyShipping(@PathVariable("id") String id){
        return shippingService.deleteMyShipping(id);
    }

    @GetMapping("/update/{id}/{name}/{phone}/{district}/{addr}")
    public boolean updateMyShipping(@PathVariable("id") String shipId,
                                    @PathVariable("name") String name,
                                    @PathVariable("phone") String phone,
                                    @PathVariable("district") String district,
                                    @PathVariable("addr") String addr){
        Shipping shipping = new Shipping(shipId,null,name,phone,district,addr,null,null);
        return shippingService.updateMyShipping(shipping);
    }



}
