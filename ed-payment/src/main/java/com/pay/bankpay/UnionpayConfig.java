package com.pay.bankpay;

public class UnionpayConfig {
    /**商户号*/
    public static final String MER_ID = "777290058181609";

    /**
     * 前端异步通知地址
     */
    public static String FRONT_URL = "http://localhost:8085/pay/success";

    /**
     * 后台异步通知地址
     */
    public static String BACK_URL = "http://xujiawei.wezoz.com/notifyurl";

}
