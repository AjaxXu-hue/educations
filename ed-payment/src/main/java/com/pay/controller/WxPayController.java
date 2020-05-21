package com.pay.controller;

import com.pay.config.wx.WXPayConstants;
import com.pay.service.LecturerExtService;
import com.pay.service.OrderInfoService;
import com.pay.config.wx.WXPayRequest;
import com.pay.config.wx.WXPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Dto;
import pojo.course.OrderInfo;
import pojo.user.LecturerExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
微信
 */
@Controller
@RequestMapping("/api/wx")
public class WxPayController {

    @Resource
    OrderInfoService orderInfoService;

    private String trade_no;

    @Resource
    LecturerExtService lecturerExtService;

    //进入微信支付页面
    @GetMapping("/index")
    public ModelAndView wxIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("WXindex");
        return mv;
    }

   //生成微信支付二维码
    @RequestMapping(value = "/createCode/{orderNo}" , method = RequestMethod.GET , produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Dto createCode(@PathVariable String orderNo){

        //查询订单
        OrderInfo order = new OrderInfo();
        order.setOrderNo(Long.parseLong(orderNo));
        List<OrderInfo> orderList = orderInfoService.findAll(order);
        System.out.println("调用方法");

        //1.构造参数
        Map<String,String> data = new HashMap<String,String>();
        data.put("body","腾讯充值中心-QQ会员充值");
        data.put("trade_type","NATIVE");
        double price = 1;
        data.put("total_fee","1");
        data.put("appid","wx171686d5566aae60");
        data.put("mch_id","1510700851");
        data.put("sign_type","MD5");
        data.put("sign","");
        data.put("fee_type","CNY");
        data.put("notify_url","http://xujiawei.wezoz.com/api/wx/notify");
        data.put("out_trade_no",orderNo);
        data.put("nonce_str",String.valueOf(System.currentTimeMillis()));
        data.put("spbill_create_ip","127.0.0.1");
        try{
            //2.转成XML请求微信平台
            String requestXml = WXPayUtil.generateSignedXml(data,"yueyanghainaruanjiankeji86055555", WXPayConstants.SignType.MD5);

            //3.请求微信支付平台获取预支付交易链接(url=同一下单URL)
            String responseXml = WXPayRequest.requestWx("https://api.mch.weixin.qq.com/pay/unifiedorder",requestXml);
            //XML转换未map
            Map<String,String> resultMap = WXPayUtil.xmlToMap(responseXml);
            if(resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS")){
                Map<String,String> result = new HashMap<String, String>();
                result.put("code_url",resultMap.get("code_url"));
                System.out.println("成功");
                trade_no = resultMap.get("prepay_id");//获取订单号
                return DtoUtil.returnDataSuccess(result);
            }else{
                System.out.println("出错------"+resultMap.get("return_msg"));
                return DtoUtil.returnFail(resultMap.get("return_msg"),"100002");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //3.获取Code_url
        return DtoUtil.returnFail("发生错误" , "1000");
    }

    //接收微信的异步通知
    @RequestMapping("/notify")
    public void wxNotify(HttpServletRequest request , HttpServletResponse response){
        //从request获取XML流 转换为MAP数据
        System.out.println("成功被调用");
        try{
            //接收数据
            StringBuffer sb = new StringBuffer();

            InputStream inputStream = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream , "UTF-8"));
            String temp;
            while ((temp=reader.readLine()) != null){
                sb.append(temp);
            }
            reader.close();
            inputStream.close();

            //转化成map
            Map<String , String > resultMap = WXPayUtil.xmlToMap(sb.toString());
            //验证是否合法
            Boolean flag = WXPayUtil.isSignatureValid(resultMap , "yueyanghainaruanjiankeji86055555" , WXPayConstants.SignType.MD5);
            if(flag){
                System.out.println("签名验证成功");
                //当前支付状态是否成功
                if(resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS")){
                    System.out.println("订单支付成功");
                    OrderInfo order = new OrderInfo();
                    String out_trade = resultMap.get("out_trade_no");//获取订单号
                    order.setOrderNo(Long.parseLong(out_trade));//订单号
                    List<OrderInfo>orderList = orderInfoService.findAll(order);
                    order.setOrderStatus(17);
                    order.setPayTime(new Date());
                    order.setPayType(15);
                    order.setPayNo(trade_no);
                    order.setId(orderList.get(0).getId());
                    orderInfoService.updateOrderInfo(order);

                    //修改讲师金额
                    LecturerExt lecturerExt = new LecturerExt();
                    lecturerExt.setLecturerUserNo(orderList.get(0).getLecturerUserNo());
                    lecturerExt.setEnableBalances(orderList.get(0).getLecturerProfit());
                    lecturerExtService.updateLectureBank(lecturerExt);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("成功返回数据");
            Map<String , String > map = new HashMap<>();
            map.put("return_code" , "success");
            map.put("return_msg" , "success");

            try{
                String mapXml = WXPayUtil.generateSignedXml(map , "yueyanghainaruanjiankeji86055555");

                //返回数据
                response.getWriter().write(mapXml);
                response.getWriter().flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //查询订单状态
    @RequestMapping(value = "/queryOrderStatus/{orderNo}" , method = RequestMethod.GET , produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Dto queryOrderStatus(@PathVariable String orderNo){
        try{
            //查询订单
            OrderInfo order = new OrderInfo();
            order.setOrderNo(Long.parseLong(orderNo));
            List<OrderInfo> orderList = orderInfoService.findAll(order);
        }catch (Exception e){
            e.printStackTrace();
        }

        return DtoUtil.returnFail("查询失败" , "40020");
    }

}
