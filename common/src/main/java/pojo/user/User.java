package pojo.user;

import java.util.Date;

//用户基本信息
public class User {
    private Integer id;
    private Date gmt_create;//创建时间
    private Date gmt_modified;//修改时间
    private boolean status_id;//状态(1:正常，0:禁用)
    private Integer user_no;//用户编号
    private String mobile;//手机号码
    private String mobile_salt;//密码盐
    private String mobile_psw;//登录密码
    private String user_source;//用户来源(client_id)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public boolean isStatus_id() {
        return status_id;
    }

    public void setStatus_id(boolean status_id) {
        this.status_id = status_id;
    }

    public Integer getUser_no() {
        return user_no;
    }

    public void setUser_no(Integer user_no) {
        this.user_no = user_no;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile_salt() {
        return mobile_salt;
    }

    public void setMobile_salt(String mobile_salt) {
        this.mobile_salt = mobile_salt;
    }

    public String getMobile_psw() {
        return mobile_psw;
    }

    public void setMobile_psw(String mobile_psw) {
        this.mobile_psw = mobile_psw;
    }

    public String getUser_source() {
        return user_source;
    }

    public void setUser_source(String user_source) {
        this.user_source = user_source;
    }
}
