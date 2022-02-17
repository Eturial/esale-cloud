package com.eturial.esale.server.system.service;


import com.eturial.esale.server.system.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findProductList();
}
