package com.system.controller;

import com.system.service.WebsiteNavService;
import com.system.service.WebsiteNavArticleService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.system.WebsiteNav;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//底部导航
@RestController
public class WebsiteNavController {

    @Resource
    WebsiteNavService websiteNavService;//站点导航

    @Resource
    WebsiteNavArticleService websiteNavArticleService;//站点导航文章

    //根据 名称,状态 查询底部导航信息
    @GetMapping("/system/webNav/findNavAll")
    public Dto findNavAll(@RequestParam(value = "navName" , required = false)String navName ,
                          @RequestParam(value = "status" , required = false) String status){

        //查询信息
        List<WebsiteNav> allNavList = websiteNavService.findAll(navName, status , null);
        if(allNavList.size() == 0){
            return DtoUtil.returnSuccess("未查询到底部导航信息");
        }

        return DtoUtil.returnDataSuccess(allNavList);
    }

    //根据ID查询信息
    @GetMapping("/system/webNav/update/findById")
    public Dto updateFindById(@RequestParam(value = "id")String id){
        WebsiteNav websiteNav = websiteNavService.findById(Long.parseLong(id));
        if(websiteNav == null){
            return DtoUtil.returnSuccess("未查询到信息");
        }

        return DtoUtil.returnDataSuccess(websiteNav);
    }

    //根据ID修改信息
    @PostMapping("/system/webNav/update/updateById")
    public Dto updateById(@RequestBody WebsiteNav websiteNav){
        //修改时间
        websiteNav.setGmtModified(new Date());

        int count = websiteNavService.updateNavInfo(websiteNav);
        if(count < 0){
            return DtoUtil.returnFail("修改异常" , "10020");
        }

        return DtoUtil.returnSuccess("修改成功");
    }

    //新增信息
    @PostMapping("/system/webNav/insertByInfo")
    public Dto insertByInfo(@RequestBody WebsiteNav websiteNav){
        //修改时间
        websiteNav.setStatusId(1);
        websiteNav.setGmtCreate(new Date());
        websiteNav.setGmtModified(new Date());

        int count = websiteNavService.insertNavInfo(websiteNav);
        if(count < 0){
            return DtoUtil.returnFail("新增异常" , "10020");
        }

        return DtoUtil.returnSuccess("新增成功");
    }

    //根据ID删除信息 [硬删除]
    @GetMapping("/system/webNav/deleteById")
    public Dto deleteById(@RequestParam(value = "id") String id){
        //删除前查询导航级别
        WebsiteNav websiteNav = websiteNavService.findById(Long.parseLong(id));
        //删除信息
        int count = websiteNavService.deleteById(Long.parseLong(id));
        if(websiteNav.getParentId() == 0){
            //查询相关的导航信息
            List<WebsiteNav> findByParentId = websiteNavService.findAll(null , null , id);

            //如果删除是一级导航(删除下方相关信息)
            count = websiteNavService.deleteByParent(Long.parseLong(id));
            //循环信息
            for (int i = 0 ; i < findByParentId.size() ; i++){
                WebsiteNav webNav = findByParentId.get(i);
                //删除相关的文章
                int num = websiteNavArticleService.deleteById(webNav.getId());
            }
        } else {
            //删除相关的文章
            int num = websiteNavArticleService.deleteById(websiteNav.getId());
        }

        if (count < 0){
            DtoUtil.returnFail("删除异常" , "10030");
        }
        return DtoUtil.returnSuccess("删除成功!!");
    }

    //链接禁用(启用) [软删除]

}
