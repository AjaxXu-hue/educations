package com.system.controller;

import io.swagger.annotations.*;
import com.system.service.adv.AdvService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.Dto;
import pojo.course.Adv;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//广告信息
@RestController
@Api(value = "AdvController" , tags = "广告信息接口")
public class AdvController {

    @Resource
    AdvService advService;

    //查询全部广告信息
    @ApiOperation(value = "查询广告信息", notes = "1.查询全部广告信息</br>2.根据条件查询信息[a.广告标题b.状态]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "advName", value = "广告名称"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "状态")})
    @GetMapping("/homepage/index/pc/findAll")
    public Dto findAll(@RequestParam(value = "advName", required = false) String advName,
                       @RequestParam(value = "status", required = false) String status) {
        //添加数据
        Adv adv = new Adv();
        adv.setAdvTitle(advName);
        adv.setStatusId(Integer.parseInt(status));
        //查询信息
        List<Adv> findAddInfo = advService.findAll(adv);
        if (findAddInfo.size() == 0) {
            return DtoUtil.returnSuccess("未查询到信息");
        }

        return DtoUtil.returnDataSuccess(findAddInfo);
    }

    //删除信息
    @ApiOperation(value = "删除信息", notes = "根据ID删除广告信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "编号")
    @DeleteMapping("/homepage/index/pc/delete")
    public Dto deleteAdvInfo(@RequestParam(value = "id", required = true) String id) {

        int count = advService.deleteById(Long.parseLong(id));
        if (count == 0) {
            return DtoUtil.returnFail("删除失败!!", "10030");
        }

        return DtoUtil.returnSuccess("删除成功");
    }

    //新增信息(图片增加)
    @ApiOperation(value = "新增信息", notes = "新增广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "advTitle" , value = "广告标题"),
            @ApiImplicitParam(paramType = "query" , name = "advUrl" , value = "广告链接"),
            @ApiImplicitParam(paramType = "query" , name = "advTarget" , value = "广告跳转方式"),
            @ApiImplicitParam(paramType = "query" , name = "sort" , value = "排序"),
            @ApiImplicitParam(paramType = "query" , name = "beginTime" , value = "开始时间"),
            @ApiImplicitParam(paramType = "query" , name = "endTime" , value = "结束时间")
    })
    @PostMapping(value = "/homepage/index/pc/insertImg" )
    public Dto deleteAdvInfo(@RequestParam(value = "advTitle" , required = true) String advTitle ,
                             @RequestParam(value = "advUrl" , required = true) String advUrl,
                             @RequestParam(value = "advTarget" , required = true) String advTarget ,
                             @RequestParam(value = "sort" , required = true) String sort ,
                             @RequestParam(value = "beginTime" , required = true) String beginTime ,
                             @RequestParam(value = "endTime" , required = true) String endTime ,
                             @RequestParam(value = "mult" , required = true) MultipartFile mult) throws ParseException {
        //定义上传路径
        String path = "F://img/";


        //获取图片原名
        String oldName = mult.getOriginalFilename();
        //获取新名字
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());

        File files = new File(path, newName);
        if (!files.exists()) {
            files.mkdirs();
        }

        try {
            //文件保存操作
            mult.transferTo(files);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnSuccess("上传失败");
        }

        //添加数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Adv adv = new Adv();
        adv.setAdvImg(path+newName);
        adv.setAdvUrl(advUrl);
        adv.setAdvTitle(advTitle);
        adv.setAdvTarget(advTarget);
        adv.setSort(sort);
        adv.setBeginTime(format.parse(beginTime));
        adv.setEndTime(format.parse(endTime));
        adv.setGmtCreate(new Date());
        adv.setGmtModified(new Date());

        //数据库操作
        int count = advService.insertAdvInfo(adv);
        if(count < 0){
            return DtoUtil.returnFail("新增失败" , "20040");
        }
        System.out.println(path+newName);

        return DtoUtil.returnSuccess("新增文件成功!!");
    }


//    {
//        "advTarget": "_self",
//        "advTitle": "测试数据",
//        "advUrl": "http://www.teachergu.com/",
//        "beginTime": "2020-05-13T09:03:57.562Z",
//        "endTime": "2020-05-13T09:03:57.562Z",
//        "sort": 20
//    }
}
