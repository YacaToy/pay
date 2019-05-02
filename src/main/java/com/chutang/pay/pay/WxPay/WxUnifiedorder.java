package com.chutang.pay.pay.WxPay;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.chutang.pay.pay.Unifiedorder;

import java.util.HashMap;
import java.util.Map;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/1
 * @time: 23:10
 */
public class WxUnifiedorder implements Unifiedorder {


    @Override
    public Map<String, String> PayUnifiedorder(PayHouse payHouse) {
        WXPay wxpay = new WXPay(payHouse.getMyConfig());
        Map<String, String> data = new HashMap<String, String>();
        if (payHouse.getDeviceInfo() != null)data.put("device_info", payHouse.getDeviceInfo());
        if (payHouse.getNonceStr() != null)data.put("nonce_str", payHouse.getNonceStr());
        if (payHouse.getBody() != null)data.put("body", payHouse.getBody());
        if (payHouse.getDetail() != null)data.put("detail", payHouse.getDetail());
        if (payHouse.getAttach() != null)data.put("attach", payHouse.getAttach());
        if (payHouse.getOutTradeNo() != null)data.put("out_trade_no", payHouse.getOutTradeNo());
        if (payHouse.getFeeType() != null)data.put("fee_type", payHouse.getFeeType());
        if (payHouse.getTotalFee() != null)data.put("total_fee", payHouse.getTotalFee());
        if (payHouse.getSpbillCreateIp() != null)data.put("spbill_create_ip", payHouse.getSpbillCreateIp());
        if (payHouse.getTimeStart() != null)data.put("time_start", payHouse.getTimeStart());
        if (payHouse.getTimeExpire() != null)data.put("time_expire", payHouse.getTimeExpire());
        if (payHouse.getGoodsTag() != null)data.put("goods_tag", payHouse.getGoodsTag());
        if (payHouse.getNotifyUrl() != null)data.put("notify_url", payHouse.getNotifyUrl());
        if (payHouse.getTradeType() != null)data.put("trade_type", payHouse.getTradeType().getValue());
        if (payHouse.getProductId() != null)data.put("product_id", payHouse.getProductId());
        if (payHouse.getLimitPay() != null)data.put("limit_pay", payHouse.getLimitPay());
        if (payHouse.getOpenid() != null)data.put("openid", payHouse.getOpenid());
        if (payHouse.getReceipt() != null)data.put("receipt", payHouse.getReceipt());
        if (payHouse.getSceneInfo() != null)data.put("scene_info", payHouse.getSceneInfo());
        try {
            Map<String, String> resp = null ;
            if (payHouse.getTradeType() == WxPayTradeType.NATIVEPAY){
                resp = wxpay.unifiedOrder(data);
//                logger.info(resp);
                return resp ;
            }else if (payHouse.getTradeType() == WxPayTradeType.JSAPIPAY){
                resp = wxpay.unifiedOrder(data);
                Map<String, String> jsapipayMap = new HashMap<String, String>();
                jsapipayMap.put("appId",payHouse.getMyConfig().getAppID());
                long l = System.currentTimeMillis();System.out.println(l);
                jsapipayMap.put("timeStamp", l+"");
                jsapipayMap.put("nonceStr",WXPayUtil.generateNonceStr());
                jsapipayMap.put("package","prepay_id="+resp.get("prepay_id"));
                jsapipayMap.put("signType","MD5");
                jsapipayMap.put("paySign",WXPayUtil.generateSignature(jsapipayMap,payHouse.getMyConfig().getKey()));
                jsapipayMap.put("return_code",resp.get("return_code"));
//                logger.info(jsapipayMap);
                return jsapipayMap ;
            }else if (payHouse.getTradeType() == WxPayTradeType.H5PAT){

            }
//            logger.info("is null");
            return resp;
        } catch (Exception e) {
//            logger.info(e);
            e.printStackTrace();
            return null;
        }
    }

}
