package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程信息-审核(CourseAudit)实体类
 */
public class CourseAudit implements Serializable {
    /**
    * 主键
    */
    private Long id;
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
    * 课程封面
    */
    private String courseLogo;
    /**
    * 原价
    */
    private Double courseOriginal;
    /**
    * 是否免费：关联字典表
    */
    private Integer isFree;
    /**
    * 状态(关联字典表)
    */
    private Integer statusId;
    /**
    * 是否上架(关联字典表)
    */
    private Integer isPutaway;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 优惠价
    */
    private Double courseDiscount;
    /**
    * 课程介绍ID
    */
    private Long introduceId;
    /**
    * 审核意见
    */
    private String auditOpinion;
    /**
    * 审核状态(关联字典表)
    */
    private Integer auditStatus;
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

    public Double getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(Double courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}