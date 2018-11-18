package com.dz.strategy;

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
