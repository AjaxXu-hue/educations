package pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 讲师信息-审核(LecturerAudit)实体类
 */
@ApiModel(value = "讲师信息-审核实体类" , description = "讲师信息-审核描述信息")
public class LecturerAudit {
    //主键
    @ApiModelProperty(value = "编号")
    private Long id;

    //讲师名称
    @ApiModelProperty(value = "讲师名称")
    private String lecturerName;

    // 讲师用户编号
    @ApiModelProperty(value = "讲师用户编号")
    private Long lecturerUserNo;

    //讲师手机
    @ApiModelProperty(value = "讲师手机")
    private String lecturerMobile;

    //职位
    @ApiModelProperty(value = "职位")
    private String position;

    //讲师邮箱
    @ApiModelProperty(value = "讲师邮箱")
    private String lecturerEmail;

    //简介
    @ApiModelProperty(value = "简介")
    private String introduce;

    //头像
    @ApiModelProperty(value = "头像")
    private String headImgUrl;

    //审核意见
    @ApiModelProperty(value = "审核意见")
    private String auditOpinion;

    //排序
    @ApiModelProperty(value = "排序")
    private Integer sort;

    //讲师分成比例
    @ApiModelProperty(value = "讲师分成比例")
    private Double lecturerProportion;

    //审核状态(关联字典表)
    @ApiModelProperty(value = "审核状态(6=待审核 7=审核通过 8=审核不通过)")
    private Integer auditStatus;

    //状态(关联字典明细表)
    @ApiModelProperty(value = "状态(1=正常 2=禁用)")
    private Integer statusId;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    //修改时间
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getLecturerMobile() {
        return lecturerMobile;
    }

    public void setLecturerMobile(String lecturerMobile) {
        this.lecturerMobile = lecturerMobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Double getLecturerProportion() {
        return lecturerProportion;
    }

    public void setLecturerProportion(Double lecturerProportion) {
        this.lecturerProportion = lecturerProportion;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
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
        return "LecturerAudit{" +
                "id=" + id +
                ", lecturerName='" + lecturerName + '\'' +
                ", lecturerUserNo=" + lecturerUserNo +
                ", lecturerMobile='" + lecturerMobile + '\'' +
                ", position='" + position + '\'' +
                ", lecturerEmail='" + lecturerEmail + '\'' +
                ", introduce='" + introduce + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", auditOpinion='" + auditOpinion + '\'' +
                ", sort=" + sort +
                ", lecturerProportion=" + lecturerProportion +
                ", auditStatus=" + auditStatus +
                ", statusId=" + statusId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}