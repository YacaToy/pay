package com.chutang.pay.pay.WxPay;

import java.util.Map;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/1
 * @time: 10:31
 * 微信支付表单
 */
public class PayHouse{
    public MyConfig getMyConfig() {
        return MyConfig;
    }

    private String limitPay ;

    private String refererUrl;

    public String getRefererUrl() {
        return refererUrl;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getSignType() {
        return signType;
    }

    public String getBody() {
        return body;
    }

    public String getDetail() {
        return detail;
    }

    public String getAttach() {
        return attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public WxPayTradeType getTradeType() {
        return tradeType;
    }

    public String getOpenid() {
        return openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    private String productId ;

    public String getProductId() {
        return productId;
    }

    private PayHouse(Builder builder){
        this.MyConfig = builder.MyConfig;
        this.refererUrl = builder.refererUrl;
        this.sign = builder.sign;
        this.signType = builder.signType ;
        this.body = builder.body ;
        this.detail = builder.detail ;
        this.attach = builder.attach ;
        this.outTradeNo = builder.outTradeNo ;
        this.feeType = builder.feeType ;
        this.totalFee = builder.totalFee ;
        this.spbillCreateIp = builder.spbillCreateIp ;
        this.timeStart = builder.timeStart ;
        this.timeExpire = builder.timeExpire ;
        this.goodsTag = builder.goodsTag ;
        this.notifyUrl = builder.notifyUrl ;
        this.tradeType = builder.tradeType ;
        this.openid = builder.openid ;
        this.receipt = builder.receipt ;
        this.sceneInfo = builder.sceneInfo ;
        this.productId = builder.productId ;
        this.payAPIType = builder.payAPIType ;
        this.limitPay = builder.limitPay;
    }

    /**
     * 微信支付配置文件
     * APPID
     * MchID
     * Key
     * HttpConnectTimeoutMs
     * HttpReadTimeoutMs
     * CertStream
     */
    private MyConfig MyConfig ;

    public static class Builder{

        private MyConfig MyConfig ;

        public Builder(MyConfig MyConfig){
            this.MyConfig = MyConfig ;
        }

        private String productId ;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this ;
        }

        private String limitPay ;

        public Builder setLimitPay(String setLimitPay){
            this.limitPay = limitPay ;
            return this ;
        }

        private String refererUrl ;

        public Builder setRefererUrl(String refererUrl) {
            this.refererUrl = refererUrl;
            return this ;
        }

        /**
         * 设备号
         */
        private String deviceInfo ;

        public Builder setDeviceInfo(String deviceInfo){
            this.deviceInfo = deviceInfo ;
            return this ;
        }
        /**
         * 随机字符串
         */
        private String nonceStr ;

        public Builder setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this ;
        }

        public Builder setSign(String sign) {
            this.sign = sign;
            return this ;
        }

        public Builder setSignType(String signType) {
            this.signType = signType;
            return this ;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this ;
        }

        public Builder setDetail(String detail) {
            this.detail = detail;
            return this ;
        }

        public Builder setAttach(String attach) {
            this.attach = attach;
            return this ;
        }

        public Builder setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this ;
        }

        public Builder setFeeType(String feeType) {
            this.feeType = feeType;
            return this ;
        }

        public Builder setTotalFee(String totalFee) {
            this.totalFee = totalFee;
            return this ;
        }

        public Builder setSpbillCreateIp(String spbillCreateIp) {
            this.spbillCreateIp = spbillCreateIp;
            return this ;
        }

        public Builder setTimeStart(String timeStart) {
            this.timeStart = timeStart;
            return this ;
        }

        public Builder setTimeExpire(String timeExpire) {
            this.timeExpire = timeExpire;
            return this ;
        }

        public Builder setGoodsTag(String goodsTag) {
            this.goodsTag = goodsTag;
            return this ;
        }

        public Builder setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this ;
        }

        public Builder setTradeType(WxPayTradeType tradeType) {
            this.tradeType = tradeType;
            return this ;
        }

        public Builder setOpenid(String openid) {
            this.openid = openid;
            return this ;
        }

        public Builder setReceipt(String receipt) {
            this.receipt = receipt;
            return this ;
        }

        public Builder setSceneInfo(String sceneInfo) {
            this.sceneInfo = sceneInfo;
            return this ;
        }

        /**
         * 签名
         */
        private String sign ;

        /**
         * 签名类型
         */
        private String signType = "MD5" ;

        /**
         * 商品描述
         */
        private String body ;

        /**
         * 商品详情
         */
        private String detail ;

        /**
         * 附加数据
         */
        private String attach	 ;

        /**
         * 商品订单号
         */
        private String 	outTradeNo ;

        /**
         * 标价币种
         * 默认人民币
         */
        private String feeType = "CNY";

        /**
         * 标价金额
         */
        private String totalFee;

        /**
         * 终端IP
         */
        private String spbillCreateIp = "123.12.12.123";

        /**
         * 交易起始时间
         */
        private String timeStart ;

        /**
         * 交易结束时间
         */
        private String timeExpire ;

        /**
         * 订单优惠标记
         */
        private String goodsTag ;

        /**
         * 通知地址
         */
        private String notifyUrl = "http://1k743729y5.51mypc.cn/pay/weChat/notify";

        /**
         * 交易类型
         * JSAPI -JSAPI支付
         * NATIVE -Native支付
         * APP -APP支付
         * 默认 JSAPI支付
         */
        private WxPayTradeType tradeType = WxPayTradeType.JSAPIPAY;

        /**
         * 用户标识
         */
        private String openid ;

        /**
         * 电子发票入口开放标识
         * 传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
         */
        private String receipt  ;

        /**
         * 场景信息
         */
        private String sceneInfo ;

        private PayAPIType payAPIType ;


        public Builder setPayAPIType(PayAPIType payAPIType) {
            this.payAPIType = payAPIType;
            return this ;
        }

        public PayHouse build() {
            return new PayHouse(this);
        }


    }

    /**
     * 设备号
     */
    private String deviceInfo ;

    /**
     * 随机字符串
     */
    private String nonceStr ;

    /**
     * 签名
     */
    private String sign ;

    /**
     * 签名类型
     */
    private String signType = "MD5" ;

    /**
     * 商品描述
     */
    private String body ;

    /**
     * 商品详情
     */
    private String detail ;

    /**
     * 附加数据
     */
    private String attach	 ;

    /**
     * 商品订单号
     */
    private String 	outTradeNo ;

    /**
     * 标价币种
     * 默认人民币
     */
    private String feeType = "CNY";

    /**
     * 标价金额
     */
    private String totalFee;

    /**
     * 终端IP
     */
    private String spbillCreateIp = "123.12.12.123";

    /**
     * 交易起始时间
     */
    private String timeStart ;

    /**
     * 交易结束时间
     */
    private String timeExpire ;

    /**
     * 订单优惠标记
     */
    private String goodsTag ;

    /**
     * 通知地址
     */
    private String notifyUrl ;

    /**
     * 交易类型
     * JSAPI -JSAPI支付
     * NATIVE -Native支付
     * APP -APP支付
     * 默认 JSAPI支付
     */
    private WxPayTradeType tradeType = WxPayTradeType.JSAPIPAY;

    /**
     * 用户标识
     */
    private String openid ;

    /**
     * 电子发票入口开放标识
     * 传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    private String receipt  ;

    /**
     * 场景信息
     */
    private String sceneInfo ;

    private PayAPIType payAPIType ;

    public Map<String,String> implement(){
        Map<String,String> map = null ;
        if (payAPIType == PayAPIType.UNIFIEDORDER){
            map = new WxUnifiedorder().PayUnifiedorder(this);
        }
        return map;
    }

}
