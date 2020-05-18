package com.pay.config;

import org.springframework.context.annotation.Configuration;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
public class AlipayConfig {
    /**
     * 商户appid
     */
    private String appID ="2016101800716105";
    /**
     * 私钥 pkcs8格式的
     */
    private String rsaPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAv3iF8DRl2ka2nWLd8SJW0KmJIxxjAZiUhmabvqZctcnzJZFqfGx0q6O701QbB8NJBeXRohQ3l2476AdntsuPk/9JopZqsWJZsXumhmf1fMy5tau5opDbmK1r4354K+wWXs3/tTfTolnsg7F0iXlC2QlyLkmgEBCRotNMe3kWX6CoOrgZ3yzo0fVibGnnGVr/zRmN1Sc3SvZD+Og89CPiXqpVplMgVuJzmGV8/Wyp+xhvmoakas87X6cv/j5PEx9cJlIZV3SLn6tvdN5S2XGKl6qjf6HQYEPsrYJm5pOxF7J8b90WLYPoezVepw0jIkzYT0c+lJBmAT9gCqrGK+2nAgMBAAECggEAQJrT6bHtOSbc0QoM8H3t006FpDEgL3Y/kFgY6RIz/NWj7wTtAVhKPAlc8gVLcPzmO6BgAF+qcXLld94oyRxq7TNAqTyS6hr01TlAaQGM7RygxpepAk/XDLqCW18euUKhB2CvUh8nUmVnZk13IJlTZf3uxYMAovcsuUfRa9GRo23GeYQjdVSaLT+++5PCb6YgOa82nZlJupk7bWbNJGJbivMZgOKlW1oHs2ctMtdyXlv2+FsFU0J9ifIvc8l5bWy9bb8wTwF1BOlFTRcl1GH+JwTwjkohy5FIXVGsj8HMLJ+/6uC126Y5G/jmWvRakYewuHuRxeRHeo2v/MAnAmnSEQKBgQDATz/HXX89fpOKcrfHo3FSWJ9vh4T6d8InksRLRn+luuw/+eyGxhecg2NcEf/D0DtlsOTupQbBFCluNi+oJfylSV0taDhH9/bNsyKqjdhCVJoyQ4HA3hzwz0nPevw0dYvqU1DyM3/T46rVWwKSJDXs35dfYvoyPI/4VALK2ovZzQKBgQCrYzhGPpvBQRiBbFRDFJZNQFGcSVqQg8n2kyvX9bIxa5JUCFZfhpOiEGmXw7qQSMir0HU/8/7tyC5haJabVoRDKG/yzrhbT9bO9TjZTVfaPkuhK+yAy4DmfFQZinOA854+Dy2T5iZTSeio+K0r8AmUi+ejV9e62lPhESrcJfihQwKBgCAQVpL4DNIE+7aWv/uiTa+sJREkaFCWjSGp/96JJ5lLXD6ifgROnPs0kOl1+s38NxsSbmk3zLN+mBXPJQ0FIGWyoL2EZfXh6x2K45nKQqd0ka0VwlmU7wBbn3PfjpN0kdqE/7cSTRrYF9Cw9vHE5dTTxtpZl1uu61Y9M6X84Fp1AoGAZsJAtW1IeeCLzt2iz+2CCKNtyyT4FfnOl/a5rOx1gMgcniG5l+Dal6r7hLEoJOZe2xVLl6K10N/bXzAUTOLcvl96b7yeMLF3+/JvuWp0KDh9pA7v6HEbwhX9XqrygfiPgmobS7gMdpez1cv0GIn9VIFlyzwZ7sCE1kcyyXhC0H0CgYAV4AQ7BvQjJDidIQFQADe4H26pXt4Pj8i5T/JD3oUj/cJFB2UhXPPLw4U8d2+Yj/QUanM/Sh7YekfeKwF8iD6g2bY9Emd8OgtiD+eToX1IVxKQbWndqUZCFW24OueEZswp2aYZhuGuZ08pSl3IK7/pE5CYZ9WRKuAIrB5NDGaY8w==";
    /**
     * 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    private String notifyUrl ="http://xujiawei.wezoz.com/aliPay/notify";
    /**
     * 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    private String returnUrl = "http://xujiawei.wezoz.com/aliPay/returnUrl";
    /**
     * 请求网关地址
     */
    private String url = "https://openapi.alipaydev.com/gateway.do";
    /**
     * 编码
     */
    private String charset = "UTF-8";
    /**
     * 返回格式
     */
    private String format = "json";
    /**
     * 支付宝公钥
     */
    private String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhh75/jFU6WAwZ+fUzdubmOYk3oxOHqw1lWgr7eIecsEfiLEXtjTtyfmVFocKx6otzXu38b6OwoOUiSKoO/j55vrgxbAXX7xF7dtJtEfn1JzZRLt8Emhlo0AeLJ2vDumAK6jLzssgbNHEr+kmTfpyRTk3sLdDT+6KcjEc5ucRRqiz1TrpwX8mprVLacVvUBdr8gDiX1ge7OKcjZ7d99i4sG7zwRIcHdkRCzpADPo2XA893/S8+RlM/9MHTJxkPiqrEa1JN9SWlxzCdqcpE4Pd5BuLWbBI9o1moiLDDUZwbaJsVp2sg8AWY5w6ExaL2IY5N4maaFEIuKnAqtv2cR5clwIDAQAB";
    /**
     * 日志记录目录
     */
    private String logPath = "/logs";
    /**
     * RSA2
     */
    private String signType = "RSA2";

    ///////////////////////////////////////////支付结果显示
    /**
     * 支付成功跳转页面
     */
    private String paymentSuccessUrl = "http://localhost:8085/pay/success.html";
    /**
     * 支付失败跳转页面
     */
    private String paymentFailureUrl = "http://localhost:8085/pay/failure.html";
    ///////////////////////////////////////////支付结果显示

    public String getAppID() {
        return appID;
    }
    public void setAppID(String appID) {
        this.appID = appID;
    }
    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }
    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }
    public String getNotifyUrl() {
        return notifyUrl;
    }
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    public String getReturnUrl() {
        return returnUrl;
    }
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCharset() {
        return charset;
    }
    public void setCharset(String charset) {
        this.charset = charset;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }
    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }
    public String getLogPath() {
        return logPath;
    }
    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
    public String getSignType() {
        return signType;
    }
    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaymentSuccessUrl() {
        return paymentSuccessUrl;
    }
    public void setPaymentSuccessUrl(String paymentSuccessUrl) {
        this.paymentSuccessUrl = paymentSuccessUrl;
    }
    public String getPaymentFailureUrl() {
        return paymentFailureUrl;
    }
    public void setPaymentFailureUrl(String paymentFailureUrl) {
        this.paymentFailureUrl = paymentFailureUrl;
    }
}

    // 商户appid
//    public static String APPID = "2016101800716105";

    // 私钥 pkcs8格式的
//    public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAv3iF8DRl2ka2nWLd8SJW0KmJIxxjAZiUhmabvqZctcnzJZFqfGx0q6O701QbB8NJBeXRohQ3l2476AdntsuPk/9JopZqsWJZsXumhmf1fMy5tau5opDbmK1r4354K+wWXs3/tTfTolnsg7F0iXlC2QlyLkmgEBCRotNMe3kWX6CoOrgZ3yzo0fVibGnnGVr/zRmN1Sc3SvZD+Og89CPiXqpVplMgVuJzmGV8/Wyp+xhvmoakas87X6cv/j5PEx9cJlIZV3SLn6tvdN5S2XGKl6qjf6HQYEPsrYJm5pOxF7J8b90WLYPoezVepw0jIkzYT0c+lJBmAT9gCqrGK+2nAgMBAAECggEAQJrT6bHtOSbc0QoM8H3t006FpDEgL3Y/kFgY6RIz/NWj7wTtAVhKPAlc8gVLcPzmO6BgAF+qcXLld94oyRxq7TNAqTyS6hr01TlAaQGM7RygxpepAk/XDLqCW18euUKhB2CvUh8nUmVnZk13IJlTZf3uxYMAovcsuUfRa9GRo23GeYQjdVSaLT+++5PCb6YgOa82nZlJupk7bWbNJGJbivMZgOKlW1oHs2ctMtdyXlv2+FsFU0J9ifIvc8l5bWy9bb8wTwF1BOlFTRcl1GH+JwTwjkohy5FIXVGsj8HMLJ+/6uC126Y5G/jmWvRakYewuHuRxeRHeo2v/MAnAmnSEQKBgQDATz/HXX89fpOKcrfHo3FSWJ9vh4T6d8InksRLRn+luuw/+eyGxhecg2NcEf/D0DtlsOTupQbBFCluNi+oJfylSV0taDhH9/bNsyKqjdhCVJoyQ4HA3hzwz0nPevw0dYvqU1DyM3/T46rVWwKSJDXs35dfYvoyPI/4VALK2ovZzQKBgQCrYzhGPpvBQRiBbFRDFJZNQFGcSVqQg8n2kyvX9bIxa5JUCFZfhpOiEGmXw7qQSMir0HU/8/7tyC5haJabVoRDKG/yzrhbT9bO9TjZTVfaPkuhK+yAy4DmfFQZinOA854+Dy2T5iZTSeio+K0r8AmUi+ejV9e62lPhESrcJfihQwKBgCAQVpL4DNIE+7aWv/uiTa+sJREkaFCWjSGp/96JJ5lLXD6ifgROnPs0kOl1+s38NxsSbmk3zLN+mBXPJQ0FIGWyoL2EZfXh6x2K45nKQqd0ka0VwlmU7wBbn3PfjpN0kdqE/7cSTRrYF9Cw9vHE5dTTxtpZl1uu61Y9M6X84Fp1AoGAZsJAtW1IeeCLzt2iz+2CCKNtyyT4FfnOl/a5rOx1gMgcniG5l+Dal6r7hLEoJOZe2xVLl6K10N/bXzAUTOLcvl96b7yeMLF3+/JvuWp0KDh9pA7v6HEbwhX9XqrygfiPgmobS7gMdpez1cv0GIn9VIFlyzwZ7sCE1kcyyXhC0H0CgYAV4AQ7BvQjJDidIQFQADe4H26pXt4Pj8i5T/JD3oUj/cJFB2UhXPPLw4U8d2+Yj/QUanM/Sh7YekfeKwF8iD6g2bY9Emd8OgtiD+eToX1IVxKQbWndqUZCFW24OueEZswp2aYZhuGuZ08pSl3IK7/pE5CYZ9WRKuAIrB5NDGaY8w==";

    // 支付宝公钥
//    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhh75/jFU6WAwZ+fUzdubmOYk3oxOHqw1lWgr7eIecsEfiLEXtjTtyfmVFocKx6otzXu38b6OwoOUiSKoO/j55vrgxbAXX7xF7dtJtEfn1JzZRLt8Emhlo0AeLJ2vDumAK6jLzssgbNHEr+kmTfpyRTk3sLdDT+6KcjEc5ucRRqiz1TrpwX8mprVLacVvUBdr8gDiX1ge7OKcjZ7d99i4sG7zwRIcHdkRCzpADPo2XA893/S8+RlM/9MHTJxkPiqrEa1JN9SWlxzCdqcpE4Pd5BuLWbBI9o1moiLDDUZwbaJsVp2sg8AWY5w6ExaL2IY5N4maaFEIuKnAqtv2cR5clwIDAQAB";



