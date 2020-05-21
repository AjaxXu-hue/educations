package com.system.controller;

import com.system.service.WebsiteBarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.system.WebsiteBar;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.List;

//头部导航
@RestController
public class WebsiteBarController {

    @Resource
    WebsiteBarService websiteBarService;

    //查询头部导航列表信息(查询所有、根据条件查询[名称、状态])
    @GetMapping("/system/webBar/findInfo")
    public Dto findAll(@RequestParam(value = "barName" , required = false)String barName ,
                       @RequestParam(value = "status" , required = false)String status){
        WebsiteBar websiteBar = new WebsiteBar();
        //判断获取数据
        if(null != barName && !barName.equals("")){
            websiteBar.setNavTitle(barName);
        }
        if(null != status && !status.equals("")){
            websiteBar.setStatusId(Integer.parseInt(status));
        }

        //查询数据
        List<WebsiteBar> barInfoList = websiteBarService.findAll(barName,status);
        if(barInfoList.size() == 0){
            return DtoUtil.returnSuccess("未查询到相关信息!!");
        }

        return DtoUtil.returnDataSuccess(barInfoList);
    }

    //根据ID查询信息

    //根据ID修改信息

    //新增信息

    //根据ID删除信息 [硬删除]

    //连接禁用(启用) [软删除]
}
