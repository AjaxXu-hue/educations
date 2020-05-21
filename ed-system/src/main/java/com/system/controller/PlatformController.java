package com.system.controller;

import com.system.service.PlatformService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.user.Platform;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.List;

//平台信息
@RestController
public class PlatformController {

    @Resource
    PlatformService platformService;

    //根据条件(客户端名称) 查询信息
    @GetMapping("/system/plat/app/findByAll")
    public Dto platFindByAll(@RequestParam(value = "clientName" , required = false)String clientName){
        Platform platform = new Platform();
        //判断数据
        if(clientName != null && clientName.equals("")) {
            platform.setClientName(clientName);
        }

        //查询数据
        List<Platform> findAll = platformService.findAll(platform);
        if(findAll.size() == 0){
            return DtoUtil.returnSuccess("未查询到信息");
        }

        return DtoUtil.returnDataSuccess(findAll);
    }

    //根据ID查询信息

    //根据ID修改信息

    //新增信息

    //根据ID删除信息 [硬删除]

    //连接禁用(启用) [软删除]
}
