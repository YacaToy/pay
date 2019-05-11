package com.chutang.pay.http;

import com.chutang.pay.utils.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/11
 * @time: 12:35
 */
public class HttpHelper {
    public static String _DEFAULT = "UTF-8";
    public static String _DOWNLOAD_STREAM_KEY = "in";
    public static String _DOWNLOAD_RESPONSE_KEY = "response";

    public HttpHelper() {
    }

    public static void setDefualut(String defaultString) {
        _DEFAULT = defaultString;
    }

    public static String getDefault() {
        return _DEFAULT;
    }

    static String bulidParamForGet(String url, Map<String, String> param, String requestCharset) throws Exception {
        return param != null && param.size() != 0 ? encodingGet(url + "?", param, requestCharset) : url;
    }

    static String encodingGet(String url, Map<String, String> param, String requestCharset) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        Iterator var5 = param.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, String> temp = (Map.Entry)var5.next();
            if (!StringUtils.isEmpty(new String[]{(String)temp.getValue()})) {
                sb.append((String)temp.getKey()).append("=").append(URLEncoder.encode((String)temp.getValue(), requestCharset)).append("&");
            }
        }

        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }

    static UrlEncodedFormEntity bulidParamForPost(Map<String, String> param, String requestCharset) throws Exception {
        List<NameValuePair> pairs = new ArrayList();
        Iterator var4 = param.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, String> temp = (Map.Entry)var4.next();
            NameValuePair pair = new BasicNameValuePair((String)temp.getKey(), (String)temp.getValue());
            pairs.add(pair);
        }

        return new UrlEncodedFormEntity(pairs, requestCharset);
    }

    static HttpEntity bulidParamForupload(Map<String, String> param, File[] files, String requestCharset) throws Exception {
        MultipartEntityBuilder muls = MultipartEntityBuilder.create();
        muls.setCharset(Charset.forName(requestCharset));
        File[] var7 = files;
        int var6 = files.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            File file = var7[var5];
            muls.addBinaryBody(file.getName(), file);
        }

        Iterator var9 = param.entrySet().iterator();

        while(var9.hasNext()) {
            Map.Entry<String, String> temp = (Map.Entry)var9.next();
            muls.addTextBody((String)temp.getKey(), (String)temp.getValue());
        }

        return muls.build();
    }
}