package pojo.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "讲师信息-审核实体类" , description = "讲师审核新增信息描述")
public class InsertLeAudit {

    //讲师名称
    @ApiModelProperty(value = "讲师名称")
    private String lecturerName;

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

    //排序
    @ApiModelProperty(value = "排序")
    private Integer sort;

    //讲师分成比例
    @ApiModelProperty(value = "讲师分成比例")
    private String lecturerProportion;

    @ApiModelProperty(value = "讲师用户编码")
    private Long lecturerUserNo;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLecturerProportion() {
        return lecturerProportion;
    }

    public void setLecturerProportion(String lecturerProportion) {
        this.lecturerProportion = lecturerProportion;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }
}
