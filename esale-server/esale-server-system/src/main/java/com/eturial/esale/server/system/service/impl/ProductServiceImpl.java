package com.eturial.esale.server.system.service.impl;


import com.eturial.esale.server.system.entity.Product;
import com.eturial.esale.server.system.mapper.ProductMapper;
import com.eturial.esale.server.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findProductList() {
        return productMapper.getProductList();
    }

}
