package com.chinagreentown.dmp.util;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by yun on 2017/4/17.
 *
 * @Description Http  请求静态方法
 */
public class HttpUtil {

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 手机加密的url
     */
    private final static String EncryptUrl = "http://115.239.138.181:8083/api/statistics?apiid=Encrypt&mdn=";

    /**
     * @param phoneNo 需要加密的电话号码
     * @return 返回加密的电话号码
     */
    public static String phoneEncrypt(String phoneNo) {
        String s = sendGet(EncryptUrl, phoneNo);
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (!jsonObject.isNull("result")) {
                return jsonObject.getString("result");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws JSONException {
        System.out.println(getPhoneArea("18968102733"));
    }

    private final static String url = "http://sj.apidata.cn/";

    public static String getPhoneArea(String phone) throws JSONException {
        try {
            String s = sendGet(url, "mobile="+phone);
            JSONObject s1 = new JSONObject(s);
            System.out.println(s1);
            return s1.getJSONObject("data").getString("city");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "not find";
    }

}
