package com.eturial.esale.server.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPicture  {

    private String picId;
    private String proId;
    private String url;
}
