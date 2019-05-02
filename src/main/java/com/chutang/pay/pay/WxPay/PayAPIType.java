package com.chutang.pay.pay.WxPay;

/**
 * 微信支付API
 */
public enum PayAPIType {
    UNIFIEDORDER("UNIFIEDORDER");
    private String value;

    PayAPIType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
