package pojo.org.leRun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.com.InsertCourseAudit;
import pojo.course.Course;
import pojo.course.CourseAudit;
import pojo.course.CourseIntroduceAudit;
import pojo.org.leRun.service.LecturerExtService;
import pojo.org.leRun.service.course.CourseAuditService;
import pojo.org.leRun.service.course.CourseIntroduceAuditService;
import pojo.org.leRun.service.course.CourseService;
import pojo.user.LecturerExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "LeExtController" , tags = "讲师详细信息接口(收益)")
public class LeExtController {

    @Resource
    LecturerExtService lecturerExtService;//课程信息

    //查看讲师详细信息
    @ApiOperation(value = "查看讲师详细信息", notes = "查看讲师详细信息")
    @ApiImplicitParam(paramType = "query", name = "leUserNo", value = "讲师编号" , required = true)
    @GetMapping("/LeExtInfo")
    public Dto courseInfo(@RequestParam(value = "leUserNo") String leUserNo ){

        LecturerExt lecturerExt = new LecturerExt();
        lecturerExt.setLecturerUserNo(Long.parseLong(leUserNo));
        List<LecturerExt> findLeInfo = lecturerExtService.findAll(lecturerExt);
        if(findLeInfo.size() == 0){
            return DtoUtil.returnSuccess("未查询到信息");
        }

        return DtoUtil.returnDataSuccess(findLeInfo);
    }


}
