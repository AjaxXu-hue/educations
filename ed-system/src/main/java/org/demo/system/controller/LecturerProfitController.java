package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.lecturer.LecturerExtService;
import org.demo.system.service.lecturer.LecturerProfitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.user.LecturerExt;
import pojo.user.LecturerProfit;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "LecturerProfitController" , tags = "讲师提现分润接口")
public class LecturerProfitController {

    @Resource
    LecturerProfitService lecturerProfitService;

    @Resource
    LecturerExtService lecturerExtService;//讲师中心-扩展表

    //根据条件查询分润信息列表
    @ApiOperation(value = "查询分润信息列表" , notes = "1.查询全部分润信息</br>2.根据条件查询分润信息[讲师名称、分润状态、时间]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "leName" , value = "用户昵称"),
            @ApiImplicitParam(paramType = "query" , name = "profitStatus" , value = "分润状态"),
            @ApiImplicitParam(paramType = "query" , name = "createDate" , value = "注册时间"),
            @ApiImplicitParam(paramType = "query" , name = "createDateTwo" , value = "注册时间(到期时间)")
    })
    @GetMapping("/lecturer/list/profit/findAll")
    public Dto findByAll(@RequestParam(value = "leName" , required = false) String leName ,
                         @RequestParam(value = "profitStatus" , required = false) String profitStatus ,
                         @RequestParam(value = "createDate" , required = false) String createDate,
                         @RequestParam(value = "createDateTwo" , required = false) String createDateTwo){

        //判断数据
        LecturerProfit lecturerProfit = new LecturerProfit();
        lecturerProfit.setLecturerName(leName);
        if(profitStatus != null && !profitStatus.equals("")){
            lecturerProfit.setProfitStatus(Integer.parseInt(profitStatus));
        }
        if(createDate != null && !createDate.equals("")){
            lecturerProfit.setGmtCreate(createDate);
        }
        if(createDateTwo != null && !createDateTwo.equals("")){
            lecturerProfit.setGmtCreateOver(createDateTwo);
        }

        List<LecturerProfit> findByAll = lecturerProfitService.findAll(lecturerProfit);
        if(findByAll.size() == 0){
            return DtoUtil.returnSuccess("未查询到分润列表信息!!");
        }

        return DtoUtil.returnDataSuccess(findByAll);
    }

    //更改分润状态
    @ApiOperation(value = "审核状态" , notes = "审核状态码:a.3=确认中</br>b.4=成功</br>c.5=失败</br>")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "leUserNo" , value = "讲师用户编号"),
            @ApiImplicitParam(paramType = "query" , name = "profitStatus" , value = "分润状态"),
            @ApiImplicitParam(paramType = "query" , name = "profitId" , value = "分润编号")
    })
    @GetMapping("/lecturer/list/profit/updateInfo")
    public Dto updateInfo(@RequestParam(value = "leUserNo" , required = true) String leUserNo ,
                          @RequestParam(value = "profitStatus" , required = true) String profitStatus,
                          @RequestParam(value = "profitId" , required = true) String profitId){
        //添加数据
        LecturerProfit lecturerProfit = new LecturerProfit();
        lecturerProfit.setLecturerUserNo(Long.parseLong(leUserNo));
        lecturerProfit.setProfitStatus(Integer.parseInt(profitStatus));

        //更改状态
        int count = lecturerProfitService.updateLeProfit(lecturerProfit);

        //判断状态
        if(count > 0){
            if(profitStatus.equals("4")){
                //根据主键查询改分润信息
                LecturerProfit lecturerProfit1 = lecturerProfitService.findById(Long.parseLong(profitId));
                //修改可提现金额
                LecturerExt lecturerExt = new LecturerExt();
                lecturerExt.setLecturerUserNo(Long.parseLong(leUserNo));//讲师编号
                lecturerExt.setEnableBalances(lecturerProfit1.getLecturerProfit());//可提金额
                lecturerExt.setTotalIncome(lecturerProfit1.getLecturerProfit());//可提金额
                //总收入
                lecturerExtService.updateLectureBank(lecturerExt);
            }
        } else {
            return DtoUtil.returnFail("审核失败!!" , "20010");
        }
        return DtoUtil.returnSuccess("审核成功!!");
    }
}
