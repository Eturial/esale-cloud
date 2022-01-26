package com.eturial.esale.server.system.mapper;

import com.eturial.esale.server.system.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> getProductList();
}
