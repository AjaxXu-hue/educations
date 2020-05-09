package org.demo.system.controller;

import org.demo.system.service.WebsiteLinkService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.system.WebsiteLink;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//友情连接
@RestController
public class WebsiteLinkController {

    @Resource
    WebsiteLinkService websiteLinkService;

    //查询友情连接列表信息(查询所有、根据条件查询[名称、状态])
    @GetMapping("/system/webLink/findInfo")
    public Dto findInfo(@RequestParam(value = "linkName" , required = false) String linkName ,
                        @RequestParam(value = "status" , required = false) String status){
        WebsiteLink websiteLink = new WebsiteLink();
        //判断数据是否为空
        if(null != linkName){
            websiteLink.setLinkName(linkName);
        } else if(null != status){
            websiteLink.setStatusId(Integer.parseInt(status));
        }

        //查询信息
        List<WebsiteLink> allWebLinkInfo = websiteLinkService.findAll(websiteLink);
        if(allWebLinkInfo.size() == 0){
            return DtoUtil.returnSuccess("未查询到相关信息!!");
        }

        return DtoUtil.returnDataSuccess(allWebLinkInfo);
    }

    //根据ID查询连接列表信息
    @GetMapping("/system/webLink/update/findById")
    public Dto findById(String linkId){
        //根据ID查询信息
        WebsiteLink websiteLink = websiteLinkService.findById(Long.parseLong(linkId));
        if(null == websiteLink){
            return DtoUtil.returnSuccess("未查询到相关信息!!");
        }

        return DtoUtil.returnDataSuccess(websiteLink);
    }

    //根据ID修改链接信息
    @PostMapping("/system/webLink/update/updateById")
    public Dto updateById(@RequestBody WebsiteLink websiteLink){
        //添加数据
        websiteLink.setGmtModified(new Date());
        //修改操作
        int count = websiteLinkService.updateLinkInfo(websiteLink);
        if(count < 0){
            return DtoUtil.returnSuccess("修改失败!!");
        }

        return DtoUtil.returnSuccess("修改成功");
    }

    //新增链接信息
    @PostMapping("/system/webLink/insertInfo")
    public Dto insertInfo(@RequestBody WebsiteLink websiteLink){

        //添加数据
        websiteLink.setGmtCreate(new Date());
        websiteLink.setGmtModified(new Date());
        websiteLink.setStatusId(1);

        //修改操作
        int count = websiteLinkService.insertLinkInfo(websiteLink);
        if(count < 0){
            return DtoUtil.returnSuccess("新增失败!!");
        }

        return DtoUtil.returnSuccess("新增成功");
    }

    //删除链接信息(硬删除)
    @GetMapping("/system/webLink/deleteById")
    public Dto deleteBuId(String id){
        //删除操作
        int count = websiteLinkService.deleteById(Long.parseLong(id));
        if(count < 0){
            DtoUtil.returnFail("删除失败" , "10010");
        }

        return DtoUtil.returnSuccess("删除成功");
    }

    //连接禁用(启用) [软删除]
    @GetMapping("/system/webLink/disableById")
    public Dto updateDelById(String id , String statusId){
        //设置禁用操作
        WebsiteLink websiteLink = new WebsiteLink();
        websiteLink.setId(Long.parseLong(id));
        websiteLink.setStatusId(Integer.parseInt(statusId));

        //修改操作
        int count = websiteLinkService.updateLinkInfo(websiteLink);
        if(count < 0){
            DtoUtil.returnFail("修改连接失败" , "10020");
        }

        return DtoUtil.returnSuccess("修改连接成功");
    }

}
