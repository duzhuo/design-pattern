## 策略模式的简单实现

### 程序运行方法

启动springBoot项目

浏览器运行http://localhost:7777/01，走OrderService；

浏览器运行http://localhost:7777/02，走TransformService；

### 核心枚举类 BusinessTypeEnum

```java

public enum BusinessTypeEnum {

    BUSINESS_ORDER("01", "订单", "orderService"),
    BUSINESS_TRANS("02", "运单", "transformService");

    private String businessCode;
    private String businessName;
    private String serviceName;

    BusinessTypeEnum(String businessCode, String businessName, String serviceName) {
        this.businessCode = businessCode;
        this.businessName = businessName;
        this.serviceName = serviceName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public static String match(String businessCode) {
        if (businessCode == null)
            return null;

        for (BusinessTypeEnum item : BusinessTypeEnum.values()) {
            if (item.getBusinessCode().equals(businessCode)) {
                return item.getServiceName();
            }
        }
        return null;
    }
}

```

### 执行器类BusinessExecutor
```java
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

```

###业务接口与实现
```java
public interface BusinessService {

    String dealBusiness();
}


@Service
public class OrderService implements BusinessService {
    @Override
    public String dealBusiness() {
        return "this is OrderService";
    }
}

@Service
public class TransformService implements BusinessService {
    @Override
    public String dealBusiness() {
        return "this is TransformService";
    }
}
```