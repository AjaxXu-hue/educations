package pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户教育信息(UserExt)实体类
 */

@ApiModel(value = "用户教育信息实体类" , description = "用户教育信息描述信息")
public class UserExt implements Serializable{
    //主键
    @ApiModelProperty(value = "主键")
    private Long id;

    //用户编号
    @ApiModelProperty(value = "用户编号")
    private Long userNo;

    //昵称
    @ApiModelProperty(value = "昵称")
    private String nickname;

    //用户手机
    @ApiModelProperty(value = "用户手机")
    private String mobile;

    //邮箱
    @ApiModelProperty(value = "email")
    private String email;

    // 年龄
    @ApiModelProperty(value = "年龄")
    private Integer age;

    //性别(关联字典表)
    @ApiModelProperty(value = "性别(关联字典表)")
    private Integer sex;

    //头像地址
    @ApiModelProperty(value = "头像地址")
    private String headImgUrl;

    // 用户类型(关联字典表)
    @ApiModelProperty(value = "用户类型(关联字典表)")
    private Integer userType;

    // 状态(关联字典表)
    @ApiModelProperty(value = "状态(关联字典表)")
    private Integer statusId;

    //备注
    @ApiModelProperty(value = "备注")
    private String remark;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    private String gmtCreate;

    // 修改时间
    @ApiModelProperty(value = "修改时间")
    private String gmtModified;

    //性别
    @ApiModelProperty(value = "性别")
    private String sexInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getSexInfo() {
        return sexInfo;
    }

    public void setSexInfo(String sexInfo) {
        this.sexInfo = sexInfo;
    }

    @Override
    public String toString() {
        return "UserExt{" +
                "id=" + id +
                ", userNo=" + userNo +
                ", nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", userType=" + userType +
                ", statusId=" + statusId +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}