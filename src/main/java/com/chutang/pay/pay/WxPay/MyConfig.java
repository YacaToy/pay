package com.chutang.pay.pay.WxPay;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/4/15
 * @time: 11:17
 */
public class MyConfig implements WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
        String certPath = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return "";
    }

    @Override
    public String getMchID() {
        return "";
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
