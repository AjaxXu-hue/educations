package pojo.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 添加课程信息-审核
 */
@ApiModel(value = "添加审核课程信息实体类" , description = "添加审核课程信息实体类")
public class InsertCourseAudit {
    //讲师用户编码
    @ApiModelProperty("讲师用户编码")
    private Long lecturerUserNo;

    //课程名称
    @ApiModelProperty("课程名称")
    private String courseName;

    //一级分类ID
    @ApiModelProperty("一级分类ID")
    private Long categoryId1;

    //二级分类ID
    @ApiModelProperty("二级分类ID")
    private Long categoryId2;

    //三级分类ID
    @ApiModelProperty("三级分类ID")
    private Long categoryId3;

    //课程封面
    @ApiModelProperty("课程封面")
    private String courseLogo;

    //原价
    @ApiModelProperty("原价")
    private Double courseOriginal;

    //是否免费：关联字典表
    @ApiModelProperty("是否免费 7=免费 8=收费")
    private Integer isFree;

    //课程简介
    @ApiModelProperty("课程简介")
    private String introduce;

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public Double getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(Double courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "InsertCourseAudit{" +
                "lecturerUserNo=" + lecturerUserNo +
                ", courseName='" + courseName + '\'' +
                ", categoryId1=" + categoryId1 +
                ", categoryId2=" + categoryId2 +
                ", categoryId3=" + categoryId3 +
                ", courseLogo='" + courseLogo + '\'' +
                ", courseOriginal=" + courseOriginal +
                ", isFree=" + isFree +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}