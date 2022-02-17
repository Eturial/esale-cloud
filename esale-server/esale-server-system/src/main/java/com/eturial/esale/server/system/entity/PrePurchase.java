package com.eturial.esale.server.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrePurchase {
    String user_id;
    Product product;
    int operation;
    int quantity;
}
