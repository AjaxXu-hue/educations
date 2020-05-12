package pojo.user;

import java.util.Date;
import java.io.Serializable;

/**
 * 讲师信息(Lecturer)实体类
 */
public class Lecturer implements Serializable {
    /**
    * 主键
    */
    private Long id;
    /**
    * 讲师用户编号
    */
    private Long lecturerUserNo;
    /**
    * 讲师名称
    */
    private String lecturerName;
    /**
    * 讲师手机
    */
    private String lecturerMobile;
    /**
    * 讲师邮箱
    */
    private String lecturerEmail;
    /**
    * 职位
    */
    private String position;
    /**
    * 头像
    */
    private String headImgUrl;
    /**
    * 简介
    */
    private String introduce;
    /**
    * 讲师分成比例
    */
    private Double lecturerProportion;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 状态(关联字典明细表)
    */
    private Integer statusId;
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

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerMobile() {
        return lecturerMobile;
    }

    public void setLecturerMobile(String lecturerMobile) {
        this.lecturerMobile = lecturerMobile;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getLecturerProportion() {
        return lecturerProportion;
    }

    public void setLecturerProportion(Double lecturerProportion) {
        this.lecturerProportion = lecturerProportion;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
        return "Lecturer{" +
                "id=" + id +
                ", lecturerUserNo=" + lecturerUserNo +
                ", lecturerName='" + lecturerName + '\'' +
                ", lecturerMobile='" + lecturerMobile + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                ", position='" + position + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", introduce='" + introduce + '\'' +
                ", lecturerProportion=" + lecturerProportion +
                ", sort=" + sort +
                ", statusId=" + statusId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}