package pojo.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//系统管理员  用户基本信息
public class SysUser implements UserDetails {
    private Integer id;
    private Long userNo;//用户编号
    private String password;//密码
    private String mobile;//手机号码
    private String real_name;//真实姓名
    private Integer dictinfoID;//状态(关联字典明细表)
    private Date gmt_create;//创建时间
    private Date gmt_modified;//修改时间
    private List<Role> roles;

    private String typeNamezh;//类型名称(中文)
    private String info;//配置项名称

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userNo=" + userNo +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", real_name='" + real_name + '\'' +
                ", dictinfoID=" + dictinfoID +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                ", roles=" + roles +
                ", typeNamezh='" + typeNamezh + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return real_name;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //get/set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public Integer getDictinfoID() {
        return dictinfoID;
    }

    public void setDictinfoID(Integer dictinfoID) {
        this.dictinfoID = dictinfoID;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getTypeNamezh() {
        return typeNamezh;
    }

    public void setTypeNamezh(String typeNamezh) {
        this.typeNamezh = typeNamezh;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
