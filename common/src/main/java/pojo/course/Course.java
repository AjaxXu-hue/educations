package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程信息(Course)实体类
 */
public class Course {
    /**
    * 主键
    */
    private Long id;
    /**
    * 课程介绍ID
    */
    private Long introduceId;
    /**
    * 讲师用户编码
    */
    private Long lecturerUserNo;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 一级分类ID
    */
    private Long categoryId1;
    /**
    * 二级分类ID
    */
    private Long categoryId2;
    /**
    * 三级分类ID
    */
    private Long categoryId3;
    /**
    * 总课时数
    */
    private Integer periodTotal;
    /**
    * 课程封面
    */
    private String courseLogo;
    /**
    * 是否免费(关联字典表)
    */
    private Integer isFree;
    /**
    * 原价
    */
    private Double courseOriginal;
    /**
    * 优惠价
    */
    private Double courseDiscount;
    /**
    * 状态(关联字典表)
    */
    private Integer statusId;
    /**
    * 是否上架(关联字典表)
    */
    private Integer isPutaway;
    /**
    * 购买人数
    */
    private Integer countBuy;
    /**
    * 学习人数
    */
    private Integer countStudy;
    /**
    * 课程排序(前端显示使用)
    */
    private Integer courseSort;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

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

    public Integer getPeriodTotal() {
        return periodTotal;
    }

    public void setPeriodTotal(Integer periodTotal) {
        this.periodTotal = periodTotal;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public Double getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(Double courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public Double getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(Double courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public Integer getCountBuy() {
        return countBuy;
    }

    public void setCountBuy(Integer countBuy) {
        this.countBuy = countBuy;
    }

    public Integer getCountStudy() {
        return countStudy;
    }

    public void setCountStudy(Integer countStudy) {
        this.countStudy = countStudy;
    }

    public Integer getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(Integer courseSort) {
        this.courseSort = courseSort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", introduceId=" + introduceId +
                ", lecturerUserNo=" + lecturerUserNo +
                ", courseName='" + courseName + '\'' +
                ", categoryId1=" + categoryId1 +
                ", categoryId2=" + categoryId2 +
                ", categoryId3=" + categoryId3 +
                ", periodTotal=" + periodTotal +
                ", courseLogo='" + courseLogo + '\'' +
                ", isFree=" + isFree +
                ", courseOriginal=" + courseOriginal +
                ", courseDiscount=" + courseDiscount +
                ", statusId=" + statusId +
                ", isPutaway=" + isPutaway +
                ", countBuy=" + countBuy +
                ", countStudy=" + countStudy +
                ", courseSort=" + courseSort +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}