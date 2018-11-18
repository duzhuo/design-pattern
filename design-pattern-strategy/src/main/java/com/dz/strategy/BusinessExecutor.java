package com.dz.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BusinessExecutor implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String run(String businessCode) {
        String serviceName = BusinessTypeEnum.match(businessCode);

        if (serviceName == null) {
            return "not match this business!!";
        }

        BusinessService businessService = (BusinessService) applicationContext.getBean(serviceName);
        return businessService.dealBusiness();
    }
}
