package com.chutang.pay.pay.WxPay;

/**
 * 微信支付方式
 */
public enum WxPayTradeType {
    JSAPIPAY("JSAPI"),NATIVEPAY("NATIVE"),H5PAT("MWEB"), ;
    private String value;

    WxPayTradeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
