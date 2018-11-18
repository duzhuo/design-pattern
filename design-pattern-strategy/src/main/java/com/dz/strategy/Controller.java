package com.dz.strategy;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Controller {
    @Resource
    private BusinessExecutor businessExecutor;

    @RequestMapping("/{businessCode}")
    public String runBusiness(@PathVariable String businessCode) {
        return businessExecutor.run(businessCode);
    }
}
