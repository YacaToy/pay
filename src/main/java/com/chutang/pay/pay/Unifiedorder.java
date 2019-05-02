package com.chutang.pay.pay;

import com.chutang.pay.pay.WxPay.PayHouse;

import java.util.Map;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/1
 * @time: 11:10
 * 统一下单
 * 现在只接入支付宝
 */
public interface Unifiedorder {

    /**
     * 微信统一下单
     * @param payHouse
     * @return
     */
     public Map<String,String> PayUnifiedorder(PayHouse payHouse);



}
