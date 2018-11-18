package com.dz.strategy;

import org.springframework.stereotype.Service;

@Service
public class TransformService implements BusinessService {
    @Override
    public String dealBusiness() {
        return "this is TransformService";
    }
}
