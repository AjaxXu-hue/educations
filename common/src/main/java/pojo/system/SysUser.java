package pojo.system;

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
    private Integer userNo;//用户编号
    private String password;//密码
    private String mobile;//手机号码
    private String realName;//真实姓名
    private boolean statusId;//状态(1:正常，0:禁用)
    private Date gmtCreate;//创建时间
    private Date gmtModified;//修改时间
    private List<Role> roles;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userNo=" + userNo +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", statusId=" + statusId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", roles=" + roles +
                '}';
    }

//    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

//    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return realName;
    }

//    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isStatusId() {
        return statusId;
    }

    public void setStatusId(boolean statusId) {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
