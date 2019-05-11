package com.chutang.pay.pay.WxPay;

import com.chutang.pay.exception.DefeatedException;
import com.chutang.pay.http.HttpUtils;
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
                System.out.println("resp : "+resp);
                isSUCCESS(resp);
                Map<String, String> nativepayMap = new HashMap<String, String>();
                nativepayMap.put("code_url",resp.get("code_url"));
                System.out.println(nativepayMap);
                return nativepayMap ;
            }else if (payHouse.getTradeType() == WxPayTradeType.JSAPIPAY){
                resp = wxpay.unifiedOrder(data);
                System.out.println("resp : "+resp);
                isSUCCESS(resp);
                Map<String, String> jsapipayMap = new HashMap<String, String>();
                jsapipayMap.put("appId",payHouse.getMyConfig().getAppID());
                jsapipayMap.put("timeStamp", System.currentTimeMillis()+"");
                jsapipayMap.put("nonceStr",WXPayUtil.generateNonceStr());
                jsapipayMap.put("package","prepay_id="+resp.get("prepay_id"));
                jsapipayMap.put("signType","MD5");
                jsapipayMap.put("paySign",WXPayUtil.generateSignature(jsapipayMap,payHouse.getMyConfig().getKey()));
                System.out.println(jsapipayMap);
                return jsapipayMap ;
            }else if (payHouse.getTradeType() == WxPayTradeType.H5PAT){
                resp = wxpay.unifiedOrder(data);
                System.out.println("resp : "+resp);
                isSUCCESS(resp);
                Map<String, String> h5patMap = new HashMap<String, String>();
                h5patMap.put("mweb_url",getWeiUrl(resp.get("mweb_url"),payHouse.getRefererUrl()));
                System.out.println(h5patMap);
                return h5patMap ;
            }
            System.out.println("is null");
            return resp;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public String getWeiUrl(String url,String refererUrl) throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Language", "zh-CN,zh;q=0.9");
        header.put("Accept-Encoding", "gzip, deflate, br");
        header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header.put("Referer", refererUrl);
        header.put("Host", "wx.tenpay.com");
        header.put("Upgrade-Insecure-Requests", "1");
        header.put("Cache-Control", "no-cache");
        header.put("Pragma", "no-cache");
        String s = HttpUtils.get(url, null, header);
        System.out.println("HTML ->"+s+" ->");
        String temp=s.substring(s.indexOf("weixin://") , s.length() - 1);
        return temp.substring(0, temp.indexOf("\""));
    }

    private void isSUCCESS(Map<String,String> resp) throws DefeatedException {
        if (resp.get("result_code").equals("SUCCESS") || resp.get("return_msg").equals("OK")){
        }else {
            throw new DefeatedException();
        }
    }

}
