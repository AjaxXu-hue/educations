package pojo.user;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户基本信息(User)实体类
 */
public class User implements Serializable {
    //主键
    private Long id;

    //状态(1:正常，0:禁用)
    private Integer statusId;

    //用户编号
    private Long userNo;

    //手机号码
    private String mobile;

    //邮箱
    private String email;

    //密码盐
    private String mobileSalt;

    //登录密码
    private String mobilePsw;
    
    //用户来源(client_id)
    private String userSource;

    //创建时间
    private Date gmtCreate;

    //修改时间
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileSalt() {
        return mobileSalt;
    }

    public void setMobileSalt(String mobileSalt) {
        this.mobileSalt = mobileSalt;
    }

    public String getMobilePsw() {
        return mobilePsw;
    }

    public void setMobilePsw(String mobilePsw) {
        this.mobilePsw = mobilePsw;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
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
        return "User{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", userNo=" + userNo +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", mobileSalt='" + mobileSalt + '\'' +
                ", mobilePsw='" + mobilePsw + '\'' +
                ", userSource='" + userSource + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}