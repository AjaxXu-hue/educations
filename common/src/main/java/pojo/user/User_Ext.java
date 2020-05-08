package pojo.user;

import java.util.Date;

//用户教育信息
public class User_Ext {
    private Integer id;
    private Date gmt_create;//创建时间
    private Date gmt_modified;//修改时间
    private boolean status_id;//状态(1:正常，0:禁用)
    private Integer user_no;//用户编号
    private boolean user_type;//用户类型(1用户，2讲师)
    private String mobile;//手机号码
    private boolean sex;//性别(1男，2女，3保密)
    private Integer age;//年龄
    private String nickname;//昵称
    private String head_img_url;//头像地址
    private String remark;//备注

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

    public boolean isUser_type() {
        return user_type;
    }

    public void setUser_type(boolean user_type) {
        this.user_type = user_type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead_img_url() {
        return head_img_url;
    }

    public void setHead_img_url(String head_img_url) {
        this.head_img_url = head_img_url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
