package com.dz.strategy;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements BusinessService {
    @Override
    public String dealBusiness() {
        return "this is OrderService";
    }
}
