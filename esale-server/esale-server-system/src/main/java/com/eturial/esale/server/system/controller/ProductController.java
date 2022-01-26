package com.eturial.esale.server.system.controller;

import com.eturial.esale.common.entity.system.SystemUser;
import com.eturial.esale.server.system.entity.Product;
import com.eturial.esale.server.system.service.IUserService;
import com.eturial.esale.server.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")

public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/CusView")
    public List<Product> user() {
        return productService.findProductList();
    }
}
