package com.chutang.pay.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/11
 * @time: 12:15
 */
public class HttpUtils {
    private static final CloseableHttpClient client = HttpClients.createDefault();

    public HttpUtils() {
    }

    public static String post(String url, Map<String, String> param) throws Exception {
        return post(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, 1000, 1000, 10000);
    }

    public static String post(String url, Map<String, String> param, Map<String, String> header) throws Exception {
        return post(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, 1000, 1000, 10000);
    }

    public static String post(String url, Map<String, String> param, String requestCharset, String responseCharset) throws Exception {
        return post(url, param, requestCharset, responseCharset, (Map)null, 1000, 1000, 10000);
    }

    public static String post(String url, Map<String, String> param, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return post(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String post(String url, Map<String, String> param, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return post(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String post(String url, Map<String, String> param, String requestCharset, String responseCharset, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return post(url, param, requestCharset, responseCharset, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String post(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header) throws Exception {
        return post(url, param, requestCharset, responseCharset, header, 1000, 1000, 10000);
    }

    public static String post(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(HttpHelper.bulidParamForPost(param, requestCharset));
        return execute(httpPost, responseCharset, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String get(String url, Map<String, String> param) throws Exception {
        return get(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, 1000, 1000, 10000);
    }

    public static String get(String url, Map<String, String> param, Map<String, String> header) throws Exception {
        return get(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, 1000, 1000, 10000);
    }

    public static String get(String url, Map<String, String> param, String requestCharset, String responseCharset) throws Exception {
        return get(url, param, requestCharset, responseCharset, (Map)null, 1000, 1000, 10000);
    }

    public static String get(String url, Map<String, String> param, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return get(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String get(String url, Map<String, String> param, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return get(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String get(String url, Map<String, String> param, String requestCharset, String responseCharset, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return get(url, param, requestCharset, responseCharset, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String get(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header) throws Exception {
        return get(url, param, requestCharset, responseCharset, header, 1000, 1000, 10000);
    }

    public static String get(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        HttpGet httpGet = new HttpGet(HttpHelper.bulidParamForGet(url, param, requestCharset));
        String result = execute(httpGet, responseCharset, header, connectTimeout, socketTimeout, connectionRequestTimeout);
        return result;
    }

    public static String upload(String url, Map<String, String> param, File[] files) throws Exception {
        return upload(url, param, files, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, 1000, 1000, 10000);
    }

    public static String upload(String url, Map<String, String> param, File[] files, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return upload(url, param, files, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String upload(String url, Map<String, String> param, File[] files, Map<String, String> header) throws Exception {
        return upload(url, param, files, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, 1000, 1000, 10000);
    }

    public static String upload(String url, Map<String, String> param, File[] files, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return upload(url, param, files, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String upload(String url, Map<String, String> param, File[] files, String requestCharset, String responseCharset) throws Exception {
        return upload(url, param, files, requestCharset, HttpHelper._DEFAULT, (Map)null, 1000, 1000, 10000);
    }

    public static String upload(String url, Map<String, String> param, File[] files, String requestCharset, String responseCharset, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return upload(url, param, files, requestCharset, HttpHelper._DEFAULT, (Map)null, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String upload(String url, Map<String, String> param, File[] files, String requestCharset, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        return upload(url, param, files, requestCharset, HttpHelper._DEFAULT, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static String upload(String url, Map<String, String> param, File[] files, String requestCharset, String responseCharset, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(HttpHelper.bulidParamForupload(param, files, requestCharset));
        return execute(httpPost, responseCharset, header, connectTimeout, socketTimeout, connectionRequestTimeout);
    }

    public static Map<String, Object> postForInputSream(String url, Map<String, String> param) throws Exception {
        return postForInputSream(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null);
    }

    public static Map<String, Object> postForInputSream(String url, Map<String, String> param, Map<String, String> header) throws Exception {
        return postForInputSream(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header);
    }

    public static Map<String, Object> postForInputSream(String url, Map<String, String> param, String requestCharset) throws Exception {
        return postForInputSream(url, param, requestCharset, HttpHelper._DEFAULT, (Map)null);
    }

    public static Map<String, Object> postForInputSream(String url, Map<String, String> param, String requestCharset, Map<String, String> header) throws Exception {
        return postForInputSream(url, param, requestCharset, HttpHelper._DEFAULT, header);
    }

    public static Map<String, Object> postForInputSream(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(HttpHelper.bulidParamForPost(param, requestCharset));
        return executeForStream(httpPost, responseCharset, header);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param) throws Exception {
        return getForInputSream(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, (Map)null);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param, Map<String, String> header) throws Exception {
        return getForInputSream(url, param, HttpHelper._DEFAULT, HttpHelper._DEFAULT, header);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param, String requestCharset) throws Exception {
        return getForInputSream(url, param, requestCharset, HttpHelper._DEFAULT, (Map)null);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param, String requestCharset, Map<String, String> header) throws Exception {
        return getForInputSream(url, param, requestCharset, HttpHelper._DEFAULT, header);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param, String requestCharset, String responseCharset) throws Exception {
        return getForInputSream(url, param, requestCharset, HttpHelper._DEFAULT, (Map)null);
    }

    public static Map<String, Object> getForInputSream(String url, Map<String, String> param, String requestCharset, String responseCharset, Map<String, String> header) throws Exception {
        HttpGet httpGet = new HttpGet(HttpHelper.bulidParamForGet(url, param, requestCharset));
        return executeForStream(httpGet, responseCharset, header);
    }

    public static Map<String, Object> executeForStream(HttpRequestBase httpRequest, String responseCharset, Map<String, String> header) throws Exception {
        Map.Entry temp;
        if (header != null && header.size() != 0) {
            Iterator var4 = header.entrySet().iterator();

            while(var4.hasNext()) {
                temp = (Map.Entry)var4.next();
                httpRequest.addHeader((String)temp.getKey(), (String)temp.getValue());
            }
        }

        temp = null;

        try {
            CloseableHttpResponse response = client.execute(httpRequest);
            HttpEntity entity = response.getEntity();
            Map<String, Object> returnMap = new HashMap();
            returnMap.put(HttpHelper._DOWNLOAD_STREAM_KEY, entity.getContent());
            returnMap.put(HttpHelper._DOWNLOAD_RESPONSE_KEY, response);
            return returnMap;
        } catch (Exception var6) {
            throw var6;
        }
    }

    public static String execute(HttpRequestBase httpRequest, String responseCharset, Map<String, String> header, int connectTimeout, int socketTimeout, int connectionRequestTimeout) throws Exception {
        if (header != null && header.size() != 0) {
            Iterator var7 = header.entrySet().iterator();

            while(var7.hasNext()) {
                Map.Entry<String, String> temp = (Map.Entry)var7.next();
                httpRequest.addHeader((String)temp.getKey(), (String)temp.getValue());
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build();
        httpRequest.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        InputStream in = null;

        try {
            response = client.execute(httpRequest);
            HttpEntity entity = response.getEntity();
            in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, responseCharset));
            StringBuffer sb = new StringBuffer();

            while(true) {
                String s = br.readLine();
                if (s == null) {
                    s = sb.toString();
                    String var14 = s;
                    return var14;
                }

                sb.append(s);
            }
        } catch (Exception var21) {
            throw var21;
        } finally {
            try {
                consume(response, in);
            } catch (IOException var20) {
                var20.printStackTrace();
            }

        }
    }

    public static void consume(CloseableHttpResponse response, InputStream in) throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }

        if (response != null) {
            response.close();
            response = null;
        }

    }
}
