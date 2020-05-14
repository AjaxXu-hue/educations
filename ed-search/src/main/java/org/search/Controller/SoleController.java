package org.search.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.search.entity.CourseSolr;
import org.search.service.SolrService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "SoleController" , tags = "课程搜索接口")
public class SoleController {

    @Resource
    SolrService solrService;

    //利用solr查询课程信息
    @ApiOperation(value = "利用solr查询课程信息", notes = "利用solr查询课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "pageNo" , value = "当前页"),
            @ApiImplicitParam(paramType = "query" , name = "courseName" , value = "课程名称")
    })
    @GetMapping("/solr/courseInfo")
    public Dto solrSelect(@RequestParam(value = "pageNo" , required = false) String pageNo ,
                          @RequestParam(value = "courseName" , required = false) String courseName){
        //判断当前页
        int num = 0;
        if(pageNo == null || pageNo.equals("")){
            num = 1;
        } else {
            num = Integer.parseInt(pageNo);
        }
        List<CourseSolr> findSolrInfo =  solrService.findByCondition(num , courseName);

        return DtoUtil.returnDataSuccess(findSolrInfo);
    }
}
