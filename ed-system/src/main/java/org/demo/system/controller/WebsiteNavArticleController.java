package org.demo.system.controller;

import org.demo.system.service.WebsiteNavArticleService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.system.WebsiteNavArticle;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;

//底部导航下的文章管理
@RestController
public class WebsiteNavArticleController {

    @Resource
    WebsiteNavArticleService websiteNavArticleService;

    //通过导航ID查询单条数据
    @GetMapping("/system/webNav/article/findById")
    public Dto articleFindById(@RequestParam(value = "navId")String navId){
        WebsiteNavArticle websiteNavArticle = websiteNavArticleService.findByNavId(Long.parseLong(navId));
        if (websiteNavArticle == null){
            return DtoUtil.returnSuccess("未查询到数据!!");
        }
        return DtoUtil.returnDataSuccess(websiteNavArticle);
    }

    //新增导航文章
    @PostMapping("/system/webNav/article/insertInfo")
    public Dto articleInsertInfo(@RequestBody WebsiteNavArticle websiteNavArticle){
        //添加数据
        websiteNavArticle.setStatusId(1);
        websiteNavArticle.setGmtCreate(new Date());
        websiteNavArticle.setGmtModified(new Date());

        int count = websiteNavArticleService.insertArticle(websiteNavArticle);
        if(count < 0){
            return DtoUtil.returnFail("新增失败" , "10020");
        }

        return DtoUtil.returnSuccess("新增成功");
    }

    //修改导航文章
    @PostMapping("/system/webNav/article/updateInfo")
    public Dto articleUpdateInfo(@RequestBody WebsiteNavArticle websiteNavArticle){
        //添加数据
        websiteNavArticle.setStatusId(1);
        websiteNavArticle.setGmtModified(new Date());

        int count = websiteNavArticleService.updateArticle(websiteNavArticle);
        if(count < 0){
            return DtoUtil.returnFail("修改失败" , "10020");
        }

        return DtoUtil.returnSuccess("修改成功");
    }

}
