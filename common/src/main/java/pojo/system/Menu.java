package pojo.system;


import java.util.Date;
import java.util.List;

public class Menu {

    private Integer id;//主键
    private String menuName;//菜单名称
    private String menuUrl;//路由路径
    private String apiUrl;//接口URL
    private Integer parentId;//父ID
    private String menuIcon;//菜单图标
    private boolean menuType;//菜单类型(1：目录 2：菜单 3：按钮)
    private boolean statusId;//状态(1:正常，0:禁用)
    private String remark;//备注
    private Date gmtCreate;//创建时间
    private Date gmtModified;//修改时间
    private List<Role> roles;

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", parentId=" + parentId +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuType=" + menuType +
                ", statusId=" + statusId +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public boolean isMenuType() {
        return menuType;
    }

    public void setMenuType(boolean menuType) {
        this.menuType = menuType;
    }

    public boolean isStatusId() {
        return statusId;
    }

    public void setStatusId(boolean statusId) {
        this.statusId = statusId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
